package com.example.myapplication.ui

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.components.MenuLayout
import com.example.myapplication.ui.components.RatingBar
import com.example.myapplication.ui.theme.Orange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThanosRestaurantScreen(modifier: Modifier = Modifier, navigateToDetail: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Row(
                    modifier = modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Outlined.Menu, contentDescription = null)
                    }
                    Spacer(modifier = modifier.weight(1F))
                }
            }, actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Outlined.Add, contentDescription = null)
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Outlined.Notifications, contentDescription = null)
                }
            })
        },
        content = {
            Column(
                modifier = modifier
                    .padding(it)
                    .verticalScroll(rememberScrollState())
            ) {
                AvatarLayout()
                FollowerLayout()
                Spacer(modifier = modifier.height(12.dp))
                StarDishes(navigateToDetail = navigateToDetail)
                Spacer(modifier = modifier.height(12.dp))
                HotVegetables()
                Spacer(modifier = modifier.height(32.dp))
            }
        },
    )
}

@Composable
fun AvatarLayout(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = null,
            modifier = modifier.size(
                84.dp
            )
        )
        Spacer(modifier = modifier.size(24.dp))
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
            modifier = modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.thanos_restaurant),
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.W500, fontSize = 24.sp
                )
            )
            Text(
                text = stringResource(id = R.string.status),
                style = MaterialTheme.typography.bodySmall.copy(color = Color.Gray)
            )
        }
    }
}


@Composable
fun FollowerLayout(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 36.dp, vertical = 18.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        InfoLayout(value = "392k", title = R.string.followers)
        InfoLayout(value = "328", title = R.string.following)
        InfoLayout(value = "256", title = R.string.dishes)
    }
}


@Composable
fun InfoLayout(modifier: Modifier = Modifier, value: String, @StringRes title: Int) {
    Column {
        Text(
            text = value, style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = stringResource(id = title),
            style = MaterialTheme.typography.bodySmall.copy(color = Color.Gray)
        )
    }
}

@Composable
fun StarDishes(modifier: Modifier = Modifier, navigateToDetail: () -> Unit) {
    Column {
        TopShadow(content = {
            MenuLayout(title = R.string.star_dishes, content = {
                Text(buildAnnotatedString {
                    withStyle(style = SpanStyle(fontSize = 24.sp)) { append("1") }
                    withStyle(style = SpanStyle()) { append("/6") }
                })
            })
        })
        Spacer(modifier = modifier.height(16.dp))
        StarDishesMenu(navigateToDetail = navigateToDetail)
    }
}

@Composable
fun StarDishesMenu(modifier: Modifier = Modifier, navigateToDetail: () -> Unit) {
    LazyRow(
        modifier = modifier,
        state = rememberLazyListState(),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(Data.menuList) { item ->
            StarDishesItem(
                name = item.name, background = item.background,
                navigateToDetail = navigateToDetail
            )
        }
    }
}

@Composable
fun StarDishesItem(
    modifier: Modifier = Modifier, @StringRes name: Int, @DrawableRes background: Int,
    navigateToDetail: () -> Unit
) {
    Box(
        modifier = modifier
            .padding(horizontal = 8.dp)
            .width(120.dp)
            .height(200.dp)
            .clickable {
                navigateToDetail()
            }
    ) {
        Image(
            painter = painterResource(id = background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(120.dp, 200.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Text(
            text = stringResource(id = name),
            modifier = modifier.padding(12.dp),
            style = MaterialTheme.typography.bodyLarge.copy(Color.White)
        )
    }

}

@Composable
fun HotVegetables(modifier: Modifier = Modifier) {
    Column {
        MenuLayout(title = R.string.hot_vegetables, content = {
            BuyButton()
        }, alignment = Alignment.CenterVertically)
        Spacer(modifier = modifier.height(8.dp))
        HotVegetablesList()
    }
}

@Composable
fun BuyButton(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color.Black.copy(alpha = 0.1F),
                        Color.Transparent
                    )
                )
            )
            .padding(horizontal = 12.dp, vertical = 18.dp),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = modifier
                .padding(horizontal = 12.dp, vertical = 2.dp)
                .clip(RoundedCornerShape(12.dp))
                .shadow(12.dp)
                .background(Color.White)
                .clickable {
                    Log.d("TAG", "Buy pressed")
                }) {
            Text(
                modifier = modifier.padding(horizontal = 12.dp, vertical = 2.dp),
                text = "BUY",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = Orange
                )
            )
        }
    }
}

@Composable
fun HotVegetablesList(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(horizontal = 18.dp)) {
        Data.hotVegetableList.forEach { item ->
            HotVegetableItem(vegetable = item, modifier = modifier)
        }
    }
}

@Composable
fun HotVegetableItem(
    modifier: Modifier = Modifier, vegetable: Vegetable
) {
    Row(
        modifier = modifier
            .padding(horizontal = 8.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = vegetable.background),
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
                text = stringResource(id = vegetable.name),
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = modifier.height(4.dp))
            RatingBar(rating = vegetable.rating)
        }

    }

}

@Composable
fun TopShadow(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .shadow(5.dp, shape = RoundedCornerShape(20.dp)),
            shape = RoundedCornerShape(20.dp),
        ) {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .background(MaterialTheme.colorScheme.background)
            ) {
                Box(
                    modifier = modifier
                        .height(20.dp)
                        .background(Color.Red)
                ) {

                }
            }
        }

        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
                .height(40.dp)
                .background(MaterialTheme.colorScheme.background)
        ) {

        }

        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
                .background(MaterialTheme.colorScheme.background)
        ) {
            content()
        }

    }

}


