package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import com.example.businesscard.ui.theme.BusinessCardTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Spacer
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,

                ){
                    Card()
                }
            }
        }
    }
}

@Composable
fun Card(modifier: Modifier = Modifier){
    Column (
        modifier
            .background(color = Color(0xFFd2e8d4))
            .fillMaxSize(),  Arrangement.SpaceEvenly, Alignment.CenterHorizontally) {
        CardImage(imagePainter = painterResource(R.drawable.android_logo), fullName = stringResource(
            id = R.string.full_name
        ), role = stringResource(id = R.string.role))
        Contact(phone = stringResource(id = R.string.phone), share = stringResource(id = R.string.share), email = stringResource(
            id = R.string.email
        ))
    }

}
@Composable
fun CardImage(
    modifier: Modifier = Modifier,
    imagePainter:Painter,
    fullName:String,
    role:String
){
    Column (
        modifier
            .padding(4.dp)
            .fillMaxHeight(0.5f) , verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(painter = imagePainter,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,

            modifier = Modifier
                .background(color = Color(0xFF073042))
                .height(124.dp)
                .width(124.dp)
        )

        Text(
            text = fullName,
            fontSize = 48.sp
        )
        Text(
            text = role,
            color = Color(0xFF006b38),
            fontSize = 14.sp,
            fontWeight = FontWeight.ExtraBold
        )
    }
}


@Composable
fun Contact(
    modifier: Modifier = Modifier,
    phone:String,
    share:String,
    email:String

){
    val callImage = painterResource(R.drawable.baseline_call_24)
    val shareImage = painterResource(R.drawable.baseline_share_24)
    val emailImage = painterResource(R.drawable.baseline_email_24)
    Column (modifier.fillMaxHeight(0.5f), Arrangement.Bottom){
        Row (modifier, Arrangement.Center ) {
            Image(painter = callImage, contentDescription = null)
            Spacer(Modifier.width(14.dp))
            Text(text = phone)

        }
        Spacer(Modifier.height(14.dp))
        Row (modifier, Arrangement.Center) {
            Image(painter = shareImage, contentDescription = null)
            Spacer(Modifier.width(14.dp))
            Text(text = share)
        }
        Spacer(Modifier.height(14.dp))
        Row (modifier, Arrangement.Center) {
            Image(painter = emailImage, contentDescription = null)
            Spacer(Modifier.width(14.dp))
            Text(text = email)

        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Card()
    }
}