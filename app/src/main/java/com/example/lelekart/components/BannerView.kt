package com.example.lelekart.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.compose.model.DotGraphic
import com.tbuonomo.viewpagerdotsindicator.compose.type.ShiftIndicatorType
import kotlinx.coroutines.delay

@Composable
fun BannerView(modifier: Modifier = Modifier){
    var bannerList by remember { mutableStateOf<List<String>>(emptyList()) }

    LaunchedEffect(Unit) {
        Firebase.firestore.collection("data")
            .document("banners")
            .get().addOnCompleteListener {
                if (it.isSuccessful) {
                    bannerList = it.result?.get("urls") as List<String>
                }
            }
    }

    Column (modifier = Modifier){
        val pagerState = rememberPagerState(
            pageCount = { bannerList.size }
        )
        LaunchedEffect(pagerState.pageCount) {
            if (pagerState.pageCount > 0) {
                while (true) {
                    delay(2000)
                    val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
                    pagerState.scrollToPage(nextPage)
                }
            }
        }
        HorizontalPager(
            state = pagerState,
            pageSpacing = 24.dp,
            modifier = Modifier
                .height(200.dp)
                .padding(16.dp)
        ) {
            AsyncImage(
                model = bannerList[it],
                contentDescription = "banner image",
                modifier = Modifier.fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
            )
        }

      //  Spacer(modifier = Modifier.height(10.dp))

        DotsIndicator(
            dotCount = bannerList.size,
            type = ShiftIndicatorType(DotGraphic(
                color = MaterialTheme.colorScheme.primary,
                size = 10.dp
            )),
            pagerState = pagerState,
        )
    }
}