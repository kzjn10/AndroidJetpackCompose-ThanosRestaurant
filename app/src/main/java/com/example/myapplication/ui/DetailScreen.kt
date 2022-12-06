package com.example.myapplication.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.components.MenuLayout
import com.example.myapplication.ui.theme.LightGray
import com.example.myapplication.ui.theme.Purple80
import com.example.myapplication.ui.theme.ThanosRestaurantTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(modifier: Modifier = Modifier, navigateUp: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                }, navigationIcon = {
                    IconButton(onClick = {
                        navigateUp()
                    }) {
                        Icon(Icons.Rounded.ArrowBack, "")
                    }

                }, actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painterResource(id = R.drawable.favorite_48px),
                            contentDescription = null,
                            modifier = modifier.padding(8.dp)
                        )
                    }
                },
            modifier = modifier.background(Color.White)
                )
        },
        content = {
            Column(
                modifier = modifier
                    .padding(it)
                    .verticalScroll(rememberScrollState())
            ) {
                Image(
                    painter = painterResource(id = R.drawable.c1),
                    contentDescription = null,
                    modifier = modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )
                HotMaterialList()
                Spacer(modifier = modifier.height(12.dp))
                VisitorList()
            }
        },
    )
}

@Composable
fun HotMaterialList(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        MenuLayout(title = R.string.material_involved, content = {
            Icon(Icons.Outlined.MoreVert, contentDescription = null)
        }, alignment = Alignment.CenterVertically)
        Data.materialList.forEach { item ->
            HotMaterialItem(material = item)
        }
    }
}

@Composable
fun HotMaterialItem(
    modifier: Modifier = Modifier, material: MaterialData
) {
    Row(
        modifier = modifier
            .padding(horizontal = 12.dp, vertical = 4.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = material.background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(64.dp, 64.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Spacer(modifier = modifier.width(8.dp))
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .weight(1F)
        ) {
            Text(
                text = stringResource(id = material.name),
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = modifier.height(4.dp))
            Text(
                text = stringResource(id = material.desc),
                style = MaterialTheme.typography.labelMedium.copy(color = LightGray)
            )
        }

    }
}

@Composable
fun VisitorList(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        MenuLayout(title = R.string.recent_visitors, content = {
            Text(
                text = stringResource(id = R.string.more),
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Purple80,
                    fontWeight = FontWeight.W500
                )
            )
        }, alignment = Alignment.CenterVertically)
        Row(
            modifier = modifier
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
        ) {
            Data.visitorList.forEach { item ->
                Image(
                    painter = painterResource(id = item),
                    contentDescription = null,
                    modifier = modifier
                        .height(72.dp)
                        .width(72.dp)
                        .padding(8.dp)
                )
            }
        }

    }
}

@Preview
@Composable
fun DetailScreenPreview(){
    ThanosRestaurantTheme {
        DetailScreen {

        }

    }
}