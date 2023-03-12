package com.github.ehsannarmani.compose.dialog.ui

import androidx.compose.animation.*
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import kotlinx.coroutines.delay


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Dialog(
    modifier:Modifier=Modifier,
    visible: Boolean,
    duration: Int,
    position: Alignment = Alignment.TopCenter,
    dialogEnterAnim:EnterTransition = scaleIn(tween(500)),
    dialogExitAnim:ExitTransition = scaleOut(tween(500)),
    progressColor: Color = Color(0xFF96FFE7),
    progressBackgroundColor: Color = Color(0xFF27C5A1),
    showProgress:Boolean = true,
    onTap:()->Unit = {},
    onEnd: () -> Unit = {},
    disableSplash:Boolean = false,
    content: @Composable (()->Unit)
) {
    var _duration by State(value = duration)
    var progress by State(value = 0f)
    val progressAnimate by animateFloatAsState(targetValue = progress, animationSpec = tween(
        durationMillis = _duration,
        easing = LinearEasing
    ), finishedListener = {
        _duration = duration
    })

    LaunchedEffect(visible) {
        if (visible) {
            progress = 1f
            delay(_duration.toLong())
            onEnd()
            // increase duration to set progress(0f) faster
            _duration = 1
            progress = 0f
        }
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .zIndex(2f), contentAlignment = position) {
        var contentModifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
        if (disableSplash){
            contentModifier = contentModifier.clickable (
                onClick = onTap,
                interactionSource = remember{
                    MutableInteractionSource()
                },
                indication = null
            )
        }else{
            contentModifier = contentModifier.clickable {
                onTap()
            }
        }
        Box(
            modifier = contentModifier
        ) {

            AnimatedVisibility(
                visible = visible,
                enter = dialogEnterAnim,
                exit =  dialogExitAnim,
            ) {
                Column(
                    modifier
                        .fillMaxWidth()
                        .clip(MaterialTheme.shapes.small)
                        .background(Color(0xFF14AA88))
                        .padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    content()
                    if (showProgress){
                        LinearProgressIndicator(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(CircleShape),
                            progress = progressAnimate,
                            color = progressColor,
                            backgroundColor = progressBackgroundColor
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun <T>State(value:T) = remember {
    mutableStateOf(value)
}