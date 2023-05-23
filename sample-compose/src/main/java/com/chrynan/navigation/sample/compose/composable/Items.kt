@file:Suppress("FunctionName")

package com.chrynan.navigation.sample.compose.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun Items(
    modifier: Modifier = Modifier,
    onItemClick: (itemId: Int) -> Unit,
    header: (@Composable () -> Unit)? = null
) {
    LazyColumn(modifier = modifier) {
        if (header != null) {
            item(key = "Header") {
                header.invoke()
            }
        }

        items(
            count = 10,
            key = { it }
        ) { index ->
            Item(
                modifier = Modifier.fillMaxWidth(),
                title = "Item ${index + 1}",
                onClick = {
                    onItemClick.invoke(index)
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Item(
    modifier: Modifier = Modifier,
    title: String,
    description: String? = null,
    icon: ImageVector? = null,
    onClick: () -> Unit
) {
    ListItem(
        modifier = modifier.clickable { onClick.invoke() },
        text = {
            Text(text = title)
        },
        secondaryText = {
            if (description != null) {
                Text(text = description)
            }
        },
        icon = {
            if (icon != null) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    imageVector = icon,
                    contentDescription = null
                )
            }
        }
    )
}
