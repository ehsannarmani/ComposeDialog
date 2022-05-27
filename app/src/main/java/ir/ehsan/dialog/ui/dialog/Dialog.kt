package ir.ehsan.dialog.ui.dialog

import androidx.compose.animation.*
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import ir.ehsan.dialog.extensions.State
import kotlinx.coroutines.delay


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Dialog(
    modifier:Modifier=Modifier.fillMaxWidth()
        .clip(MaterialTheme.shapes.small)
        .background(Color(0xFF14AA88))
        .padding(10.dp),
    visible: Boolean,
    duration: Int,
    position: Alignment = Alignment.TopCenter,
    animation: DialogAnimation = DialogAnimation.Shrink,
    progressColor: Color = Color(0xFF96FFE7),
    progressBackgroundColor: Color = Color(0xFF27C5A1),
    onEnd: () -> Unit = {},
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

    Box(modifier = Modifier.fillMaxSize().zIndex(2f), contentAlignment = position) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {

            val enterAnim:EnterTransition
            val exitAnim:ExitTransition

            when(animation){
                DialogAnimation.Shrink->{
                    enterAnim = expandVertically(animationSpec = tween(700))
                    exitAnim = shrinkVertically(animationSpec = tween(700))
                }
                DialogAnimation.Zoom->{
                    enterAnim = scaleIn(animationSpec = tween(700))
                    exitAnim = scaleOut(animationSpec = tween(700))
                }
                DialogAnimation.Slide->{
                    enterAnim = slideInHorizontally(animationSpec = tween(700))
                    exitAnim = slideOutHorizontally(animationSpec = tween(700))
                }
            }

            AnimatedVisibility(
                visible = visible,
                enter = fadeIn(animationSpec = tween(1000)) + enterAnim,
                exit = fadeOut(animationSpec = tween(1000)) + exitAnim,
            ) {
                Column(
                    modifier,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    content()
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