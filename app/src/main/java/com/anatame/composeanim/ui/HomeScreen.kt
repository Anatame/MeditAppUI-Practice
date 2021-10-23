package com.anatame.composeanim.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anatame.composeanim.R
import com.anatame.composeanim.ui.theme.ButtonBlue
import com.anatame.composeanim.ui.theme.DarkerButtonBlue
import com.anatame.composeanim.ui.theme.DeepBlue
import com.anatame.composeanim.ui.theme.TextWhite
import com.anatame.composeanim.ui.theme.composables.CurrentMeditation

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ){
        Column {
            GreetingSection()
            ChipSection(chips = listOf("Sweet sleep", "Insomnia", "Depreshion"))
            CurrentMeditation()
        }
    }
}

@Preview
@Composable
fun GreetingSection(
    name: String = "Test"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Good morning, $name",
                style = MaterialTheme.typography.h2,
                color = TextWhite
            )
            Text(
                text = "We wish you have a good day!",
                style = MaterialTheme.typography.body1,
                color = TextWhite
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_search_24),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier
                .size(24.dp)
                .weight(.3f)
        )
    }
}

@Composable
fun ChipSection(
    chips: List<String>
){
    var selectedChipIndex by remember {
        mutableStateOf(0);
    }
    LazyRow(){
        items(chips.size){
            Box(
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonBlue else DarkerButtonBlue
                    )
                    .padding(15.dp)
            ){
                Text(text = chips[it], color = TextWhite)
            }
        }
    }

}

