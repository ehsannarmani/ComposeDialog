package ir.ehsan.dialog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
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
                        duration = 2000,
                        position= Alignment.TopCenter,
                        dialogEnterAnim = scaleIn(tween(500)) + fadeIn(tween(600)),
                        dialogExitAnim = scaleOut(tween(500)) + fadeOut(tween(600)),
                        onEnd = { dialogVisible = false },
                    ) {
                        Text(
                            text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                            color = Color.White,
                            fontSize = 13.sp,
                            textAlign = TextAlign.Justify
                        )
                    }
                    var dialogVisible2 by State(value = false)
                    Dialog(
                        visible = dialogVisible2,
                        duration = 2000,
                        position= Alignment.TopCenter,
                        dialogEnterAnim = expandVertically(),
                        dialogExitAnim = shrinkVertically(),
                        onEnd = { dialogVisible2 = false },
                    ) {
                        Text(
                            text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                            color = Color.White,
                            fontSize = 13.sp,
                            textAlign = TextAlign.Justify
                        )
                    }
                    var dialogVisible3 by State(value = false)
                    Dialog(
                        visible = dialogVisible3,
                        duration = 2000,
                        position= Alignment.BottomCenter,
                        dialogEnterAnim = expandHorizontally(),
                        dialogExitAnim = shrinkHorizontally(),
                        onEnd = { dialogVisible3 = false },
                    ) {
                        Text(
                            text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                            color = Color.White,
                            fontSize = 13.sp,
                            textAlign = TextAlign.Justify
                        )
                    }
                    var dialogVisible4 by State(value = false)
                    Dialog(
                        visible = dialogVisible4,
                        duration = 2000,
                        position= Alignment.Center,
                        dialogEnterAnim = expandIn(),
                        dialogExitAnim = shrinkOut(),
                        onEnd = { dialogVisible4 = false },
                    ) {
                        Text(
                            text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                            color = Color.White,
                            fontSize = 13.sp,
                            textAlign = TextAlign.Justify
                        )
                    }

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(onClick = { dialogVisible = true }) {
                            Text(text = "Call Me! (Scale)", fontFamily = yekan, fontSize = 13.sp)
                        }
                        Spacer(Modifier.height(8.dp))
                        Button(onClick = { dialogVisible2 = true }) {
                            Text(text = "Call Me(Slide)", fontFamily = yekan, fontSize = 13.sp)
                        }
                        Spacer(Modifier.height(8.dp))
                        Button(onClick = { dialogVisible3 = true }) {
                            Text(text = "Call Me(Slide)", fontFamily = yekan, fontSize = 13.sp)
                        }
                        Spacer(Modifier.height(8.dp))
                        Button(onClick = { dialogVisible4 = true }) {
                            Text(text = "Call Me(Expand/Shrink)", fontFamily = yekan, fontSize = 13.sp)
                        }
                    }
                }
            }
        }
    }
}




