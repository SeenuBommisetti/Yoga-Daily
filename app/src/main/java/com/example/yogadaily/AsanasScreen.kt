package com.example.yogadaily

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.yogadaily.model.Asana
import com.example.yogadaily.ui.theme.YogaDailyTheme

@Composable
fun AsanaList(
    asana: List<Asana>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)

) {
    LazyColumn(
        contentPadding = contentPadding,
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(asana) { item ->
            AsanaListItem(
                asana = item,
                modifier = modifier.padding(start = 8.dp)
            )
        }
    }

}

@Composable
fun AsanaListItem(
    asana: Asana,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue = if(expanded) MaterialTheme.colorScheme.tertiaryContainer
        else MaterialTheme.colorScheme.primaryContainer
    )
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        shape = MaterialTheme.shapes.medium,
        onClick = {
            expanded = !expanded
        },
        modifier = modifier
    ) {
        AsanaInformation(
            expanded = expanded,
            color = color,
            asana = asana
        )
    }
}

@Composable
fun AsanaInformation(
    expanded: Boolean,
    color: Color,
    asana: Asana,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.animateContentSize(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioNoBouncy,
                stiffness = Spring.StiffnessMedium
            )
        )
            .background(color = color)
    ) {
        Text(
            text = stringResource(asana.dayRes),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(start = 2.dp)
        )
        Text(
            text = stringResource(asana.titleRes),
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = modifier.padding(4.dp))
        AsanaImage(asana = asana)
        Spacer(modifier = modifier.padding(4.dp))
        if(expanded) {
            Text(
                text = stringResource(R.string.benefits),
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = stringResource(asana.benefitsRes),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(start = 8.dp)
            )
            Spacer(modifier = modifier.padding(4.dp))
            Text(
                text = stringResource(R.string.steps),
                style = MaterialTheme.typography.titleMedium
            )
            asana.stepsRes.forEachIndexed { index, stepsId ->
                Text(
                    text = "${index + 1}. ${stringResource(stepsId)}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }


}

@Composable
fun AsanaImage(
    asana: Asana,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(asana.imageRes),
        contentDescription = "Image of ${stringResource(asana.titleRes)}",
        contentScale = ContentScale.Fit,
        modifier = modifier.clip(MaterialTheme.shapes.small)
    )
}

@Preview
@Composable
fun AsanaListItemPreview() {
    val asana = Asana(
        R.string.day_1,
        R.string.day_1_title,
        R.drawable.asana_image_1,
        R.string.day_1_benefits,
        listOf(
            R.string.day_1_step_1,
            R.string.day_1_step_2,
            R.string.day_1_step_3,
            R.string.day_1_step_4
        )
    )
   YogaDailyTheme {
       AsanaListItem(
           asana = asana
       )
   }
}
