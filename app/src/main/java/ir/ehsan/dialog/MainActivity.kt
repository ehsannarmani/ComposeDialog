package ir.ehsan.dialog

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.ehsan.dialog.extensions.State
import ir.ehsan.dialog.ui.dialog.Dialog
import ir.ehsan.dialog.ui.dialog.DialogAnimation
import ir.ehsan.dialog.ui.theme.DialogTheme
import ir.ehsan.dialog.ui.theme.yekan

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DialogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var dialogVisible by State(value = false)
                    Dialog(
                        visible = dialogVisible,
                        duration = 5000,
                        position= Alignment.BottomCenter,
                        animation = DialogAnimation.Shrink,
                        onEnd = { dialogVisible = false },
                    ) {
                        Text(
                            text = "لورم ایپسوم متن ساختگی با تولید سادگی نامفهوم از صنعت چاپ و با استفاده از طراحان گرافیک است چاپگرها و متون بلکه روزنامه و مجله در ستون و سطرآنچنان که لازم است و برای شرایط فعلی تکنولوژی مورد نیاز و کاربردهای متنوع با هدف بهبود ابزارهای کاربردی می باشد کتابهای زیادی در شصت و سه درصد گذشته حال و آینده",
                            color = Color.White,
                            fontSize = 13.sp,
                            textAlign = TextAlign.End
                        )
                    }

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(onClick = { dialogVisible = true }) {
                            Text(text = "فشارم بده", fontFamily = yekan, fontSize = 13.sp)
                        }
                    }
                }
            }
        }
    }
}




