package com.example.lelekart.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.lelekart.data.Banner
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.pager.HorizontalPager
import kotlinx.coroutines.delay

@Composable
fun BannerView(banners: List<Banner>){
    if (banners.isEmpty()) {
        return
    }
    val pagerState = rememberPagerState()
    LaunchedEffect(pagerState) {
        while (true) {
            delay(2000)
            val nextPage = (pagerState.currentPage + 1) % banners.size
            pagerState.animateScrollToPage(nextPage)
        }
    }
    
    HorizontalPager(
        count = banners.size,
        state = pagerState,
    ) { page ->
        AsyncImage(
            model = banners[page].imageUrl,
            contentDescription = banners[page].title,
            modifier = Modifier.fillMaxWidth()
                .height(150.dp)
                .clip(RoundedCornerShape(16.dp))
                .padding(horizontal = 8.dp)
        )
    }

    HorizontalPagerIndicator(
        pagerState = pagerState,
        modifier = Modifier.padding(start = 180.dp)
    )
}