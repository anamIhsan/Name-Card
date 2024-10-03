package id.ihsan.namecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                BusinessCard() // Mengimport function BusinessCard
            }
        }
    }
}

@Composable
fun BusinessCard() { // Function BusinessCard
    Card( // Untuk membentuk block Kartu
        modifier = Modifier // untuk memodifikasi ukuran, jarak dll
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp), // untuk membuat radius pada kartu
//        elevation = 4.dp
    ) {
        Column( // untuk membuat konten vertical
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally // untuk menengahkan konten yang ada pada vertikal konten
        ) {
            Image( // untuk membuat gambar
                painter = painterResource(id = R.drawable.profile_picture), // untuk mengimport gambar
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop // untuk mengatur ukuran gambar
            )

            Spacer(modifier = Modifier.height(8.dp)) // untuk membuat space pada setiap komponen

            Text( // membuat konteks
                text = "Anam Ihsan",
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Roammer",
                fontSize = 16.sp
            )
        }
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            ContactItem( // menggunakan function contactItem
                icon = Icons.Default.Phone, // Icon
                contactType = "Phone", // text
                contactValue = "+62 858-9449-5598" // Text
            )

            Spacer(modifier = Modifier.height(8.dp))

            ContactItem(
                icon = Icons.Default.Email,
                contactType = "Email",
                contactValue = "anamihsan96@gmail.com"
            )

            Spacer(modifier = Modifier.height(8.dp))

            ContactItem(
                icon = Icons.Default.Place,
                contactType = "Address",
                contactValue = "St, Kemayoran, Jakarta pusat"
            )
        }

    }
}

@Composable
fun ContactItem(icon: androidx.compose.ui.graphics.vector.ImageVector, contactType: String, contactValue: String) { // function contactItem
    Row( // Untuk membuat konten horizontal
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon( // Icon
            imageVector = icon,
            contentDescription = contactType,
            modifier = Modifier.size(24.dp),
            tint = Color.Gray
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = contactType,
                fontSize = 14.sp,
                color = Color.Gray
            )
            Text(
                text = contactValue,
                fontSize = 16.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBusinessCard() {
    BusinessCard()
}
