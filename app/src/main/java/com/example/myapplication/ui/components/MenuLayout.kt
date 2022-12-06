package com.example.myapplication.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun MenuLayout(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    content: @Composable () -> Unit,
    alignment: Alignment.Vertical = Alignment.Bottom,
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding( horizontal = 24.dp),
        verticalAlignment = alignment
    ) {
        Text(
            text = stringResource(id = title),
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.W500),
            modifier = modifier
                .fillMaxWidth()
                .weight(1f)
        )
        content()
    }
}