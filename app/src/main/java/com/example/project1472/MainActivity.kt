package com.example.project1472

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            profile()
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun profile() {
        Column(
            Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(color = Color(android.graphics.Color.parseColor("#ececec"))),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ConstraintLayout() {
                val (topImg, profile) = createRefs()
                Image(
                    painter = painterResource(id = R.drawable.top_background),
                    contentDescription = null,
                    Modifier
                        .fillMaxWidth()
                        .constrainAs(topImg) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                        })

                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = null,
                    Modifier
                        .constrainAs(profile) {
                            top.linkTo(topImg.bottom)
                            bottom.linkTo(topImg.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        })
            }
            Text(
                "Sang Cheol",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp),
                color = Color(
                    android.graphics.Color.parseColor("#747679")
                )
            )
            Text(
                "Sangcheol@gmail.com",
                fontSize = 20.sp,
                color = Color(android.graphics.Color.parseColor("#747679"))
            )
            // Reusable Button Composable
            CustomButton(
                onClick = { /*Handle the first button click*/ },
                iconId = R.drawable.ic_1,
                buttonText = "My Review"
            )
            // Account Settings Button
            CustomButton(
                onClick = { /*Handle the second button click*/ },
                iconId = R.drawable.ic_2,
                buttonText = "Account Settings"
            )
            // Personal information Button
            CustomButton(
                onClick = { /*Handle the third button click*/ },
                iconId = R.drawable.ic_3,
                buttonText = "Personal Information"
            )
            // Notification Button
            CustomButton(
                onClick = { /*Handle the fourth button*/ },
                iconId = R.drawable.ic_4,
                buttonText = "Notification"
            )
            // Fingerprint Settings
            CustomButton(
                onClick = { /*Handle the fifth button*/ },
                iconId = R.drawable.ic_5,
                buttonText = "Fingerprint"
            )
            // Back to Main Page
            CustomButton(
                onClick = { /*Back to Main Page*/ },
                iconId = R.drawable.ic_back,
                buttonText = "Back to Main Page"
            )
        }
    }

    @Composable
    fun CustomButton(
        onClick: () -> Unit,
        iconId: Int,
        buttonText: String,
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
                .height(55.dp)
                .background(Color.Transparent)
                .clip(RoundedCornerShape(15.dp))
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = iconId),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(end = 5.dp)
                        .clickable { onClick() }
                )
                Spacer(modifier = Modifier.width(8.dp)) // Add some spacing
                Text(
                    text = buttonText,
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f) // Use weight to make text expand and push the image to the left
                )
            }
        }
    }
}