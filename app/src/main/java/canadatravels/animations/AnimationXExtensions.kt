package canadatravels.animations

import android.animation.Animator
import android.animation.AnimatorSet
import android.view.View
import canadatravels.animations.Attention.ATTENTION
import canadatravels.animations.Attention.ATTENTION_BOUNCE
import canadatravels.animations.Attention.ATTENTION_FLASH
import canadatravels.animations.Attention.ATTENTION_PULSE
import canadatravels.animations.Attention.ATTENTION_RUBERBAND
import canadatravels.animations.Attention.ATTENTION_SHAKE
import canadatravels.animations.Attention.ATTENTION_STAND_UP
import canadatravels.animations.Attention.ATTENTION_SWING
import canadatravels.animations.Attention.ATTENTION_TA_DA
import canadatravels.animations.Attention.ATTENTION_WAVE
import canadatravels.animations.Attention.ATTENTION_WOBBLE
import canadatravels.animations.Bounce.BOUNCE
import canadatravels.animations.Bounce.BOUNCE_IN
import canadatravels.animations.Bounce.BOUNCE_IN_DOWN
import canadatravels.animations.Bounce.BOUNCE_IN_LEFT
import canadatravels.animations.Bounce.BOUNCE_IN_RIGHT
import canadatravels.animations.Bounce.BOUNCE_IN_UP
import canadatravels.animations.Fade.FADE
import canadatravels.animations.Fade.FADE_IN
import canadatravels.animations.Fade.FADE_IN_DOWN
import canadatravels.animations.Fade.FADE_IN_LEFT
import canadatravels.animations.Fade.FADE_IN_RIGHT
import canadatravels.animations.Fade.FADE_IN_UP
import canadatravels.animations.Fade.FADE_OUT
import canadatravels.animations.Fade.FADE_OUT_DOWN
import canadatravels.animations.Fade.FADE_OUT_LEFT
import canadatravels.animations.Fade.FADE_OUT_RIGHT
import canadatravels.animations.Fade.FADE_OUT_UP
import canadatravels.animations.Flip.FLIP
import canadatravels.animations.Flip.FLIP_IN_X
import canadatravels.animations.Flip.FLIP_IN_Y
import canadatravels.animations.Flip.FLIP_OUT_X
import canadatravels.animations.Flip.FLIP_OUT_Y
import canadatravels.animations.Rotate.ROTATE
import canadatravels.animations.Rotate.ROTATE_IN
import canadatravels.animations.Rotate.ROTATE_IN_DOWN_LEFT
import canadatravels.animations.Rotate.ROTATE_IN_DOWN_RIGHT
import canadatravels.animations.Rotate.ROTATE_IN_UP_LEFT
import canadatravels.animations.Rotate.ROTATE_IN_UP_RIGHT
import canadatravels.animations.Rotate.ROTATE_OUT
import canadatravels.animations.Rotate.ROTATE_OUT_DOWN_LEFT
import canadatravels.animations.Rotate.ROTATE_OUT_DOWN_RIGHT
import canadatravels.animations.Rotate.ROTATE_OUT_UP_LEFT
import canadatravels.animations.Rotate.ROTATE_OUT_UP_RIGHT
import canadatravels.animations.Slide.SLIDE
import canadatravels.animations.Slide.SLIDE_IN_DOWN
import canadatravels.animations.Slide.SLIDE_IN_LEFT
import canadatravels.animations.Slide.SLIDE_IN_RIGHT
import canadatravels.animations.Slide.SLIDE_IN_UP
import canadatravels.animations.Slide.SLIDE_OUT_DOWN
import canadatravels.animations.Slide.SLIDE_OUT_LEFT
import canadatravels.animations.Slide.SLIDE_OUT_RIGHT
import canadatravels.animations.Slide.SLIDE_OUT_UP
import canadatravels.animations.Zoom.ZOOM
import canadatravels.animations.Zoom.ZOOM_IN
import canadatravels.animations.Zoom.ZOOM_IN_DOWN
import canadatravels.animations.Zoom.ZOOM_IN_LEFT
import canadatravels.animations.Zoom.ZOOM_IN_RIGHT
import canadatravels.animations.Zoom.ZOOM_IN_UP
import canadatravels.animations.Zoom.ZOOM_OUT
import canadatravels.animations.Zoom.ZOOM_OUT_DOWN
import canadatravels.animations.Zoom.ZOOM_OUT_LEFT
import canadatravels.animations.Zoom.ZOOM_OUT_RIGHT
import canadatravels.animations.Zoom.ZOOM_OUT_UP


fun View.animationXAttention(
    animationKey: String,
    duration: Long = 1000,
    listener: Animator.AnimatorListener? = null
) {
    renderAnimation(ATTENTION, animationKey, duration, listener)
}

fun View.animationXBounce(
    animationKey: String,
    duration: Long = 1000,
    listener: Animator.AnimatorListener? = null
) {
    renderAnimation(BOUNCE, animationKey, duration, listener)
}

fun View.animationXFade(
    animationKey: String,
    duration: Long = 1000,
    listener: Animator.AnimatorListener? = null
) {
    renderAnimation(FADE, animationKey, duration, listener)
}

fun View.animationXFlip(
    animationKey: String,
    duration: Long = 1000,
    listener: Animator.AnimatorListener? = null
) {
    renderAnimation(FLIP, animationKey, duration, listener)
}

fun View.animationXRotate(
    animationKey: String,
    duration: Long = 1000,
    listener: Animator.AnimatorListener? = null
) {
    renderAnimation(ROTATE, animationKey, duration, listener)
}

fun View.animationXSlide(
    animationKey: String,
    duration: Long = 1000,
    listener: Animator.AnimatorListener? = null
) {
    renderAnimation(SLIDE, animationKey, duration, listener)
}

fun View.animationXZoom(
    animationKey: String,
    duration: Long = 1000,
    listener: Animator.AnimatorListener? = null
) {
    renderAnimation(ZOOM, animationKey, duration, listener)
}

fun View.renderAnimation(
    key: String,
    animationKey: String,
    duration: Long,
    listener: Animator.AnimatorListener? = null
) {
    val aniObject = AnimationX().setDuration(duration)
        .setAnimation(showAnimation(this, key, animationKey, AnimationX().getNewAnimatorSet()))
    aniObject.getNewAnimatorSet().addListener(listener)
    aniObject.start()
}

private fun showAnimation(
    view: View,
    key: String,
    animationKey: String,
    animatorSet: AnimatorSet
): AnimatorSet {
    return when (key) {
        /**
         * Attention
         */
        ATTENTION -> {
            val attention = Attention
            return when (animationKey) {
                ATTENTION_BOUNCE -> attention.bounce(view, animatorSet)
                ATTENTION_FLASH -> attention.flash(view, animatorSet)
                ATTENTION_PULSE -> attention.pulse(view, animatorSet)
                ATTENTION_RUBERBAND -> attention.ruberBand(view, animatorSet)
                ATTENTION_SHAKE -> attention.shake(view, animatorSet)
                ATTENTION_STAND_UP -> attention.standUp(view, animatorSet)
                ATTENTION_SWING -> attention.swing(view, animatorSet)
                ATTENTION_TA_DA -> attention.taDa(view, animatorSet)
                ATTENTION_WAVE -> attention.wave(view, animatorSet)
                ATTENTION_WOBBLE -> attention.wobble(view, animatorSet)
                else -> attention.bounce(view, animatorSet)
            }
        }

        /**
         * Bounce
         */
        BOUNCE -> {
            val bounce = Bounce
            return when (animationKey) {
                BOUNCE_IN_DOWN -> bounce.inDown(view, animatorSet)
                BOUNCE_IN_UP -> bounce.inUp(view, animatorSet)
                BOUNCE_IN_LEFT -> bounce.inLeft(view, animatorSet)
                BOUNCE_IN_RIGHT -> bounce.inRight(view, animatorSet)
                BOUNCE_IN -> bounce.`in`(view, animatorSet)
                else -> bounce.inDown(view, animatorSet)
            }
        }

        /**
         * Fade
         */
        FADE -> {
            val fade = Fade
            return when (animationKey) {
                FADE_IN_DOWN -> fade.inDown(view, animatorSet)
                FADE_IN_UP -> fade.inUp(view, animatorSet)
                FADE_IN_LEFT -> fade.inLeft(view, animatorSet)
                FADE_IN_RIGHT -> fade.inRight(view, animatorSet)
                FADE_OUT_DOWN -> fade.outDown(view, animatorSet)
                FADE_OUT_UP -> fade.outUp(view, animatorSet)
                FADE_OUT_LEFT -> fade.outLeft(view, animatorSet)
                FADE_OUT_RIGHT -> fade.outRight(view, animatorSet)
                FADE_IN -> fade.`in`(view, animatorSet)
                FADE_OUT -> fade.out(view, animatorSet)
                else -> fade.inDown(view, animatorSet)
            }
        }

        /**
         * Flip
         */
        FLIP -> {
            val flip = Flip
            return when (animationKey) {
                FLIP_IN_X -> flip.inX(view, animatorSet)
                FLIP_IN_Y -> flip.inY(view, animatorSet)
                FLIP_OUT_X -> flip.outX(view, animatorSet)
                FLIP_OUT_Y -> flip.outY(view, animatorSet)
                else -> flip.inX(view, animatorSet)
            }
        }

        /**
         * Rotate
         */
        ROTATE -> {
            val rotate = Rotate
            return when (animationKey) {
                ROTATE_IN_DOWN_LEFT -> rotate.inDownLeft(view, animatorSet)
                ROTATE_IN_DOWN_RIGHT -> rotate.inDownRight(view, animatorSet)
                ROTATE_IN_UP_LEFT -> rotate.inUpLeft(view, animatorSet)
                ROTATE_IN_UP_RIGHT -> rotate.inUpRight(view, animatorSet)
                ROTATE_OUT_DOWN_LEFT -> rotate.outDownLeft(view, animatorSet)
                ROTATE_OUT_DOWN_RIGHT -> rotate.outDownRight(view, animatorSet)
                ROTATE_OUT_UP_LEFT -> rotate.outUpLeft(view, animatorSet)
                ROTATE_OUT_UP_RIGHT -> rotate.outUpRight(view, animatorSet)
                ROTATE_IN -> rotate.`in`(view, animatorSet)
                ROTATE_OUT -> rotate.out(view, animatorSet)
                else -> rotate.inDownLeft(view, animatorSet)
            }
        }

        /**
         * Slide
         */
        SLIDE -> {
            val slide = Slide
            return when (animationKey) {
                SLIDE_IN_DOWN -> slide.inDown(view, animatorSet)
                SLIDE_IN_UP -> slide.inUp(view, animatorSet)
                SLIDE_IN_LEFT -> slide.inLeft(view, animatorSet)
                SLIDE_IN_RIGHT -> slide.inRight(view, animatorSet)
                SLIDE_OUT_DOWN -> slide.outDown(view, animatorSet)
                SLIDE_OUT_UP -> slide.outUp(view, animatorSet)
                SLIDE_OUT_LEFT -> slide.outLeft(view, animatorSet)
                SLIDE_OUT_RIGHT -> slide.outRight(view, animatorSet)
                else -> slide.inDown(view, animatorSet)
            }
        }

        /**
         * Zoom
         */
        ZOOM -> {
            val zoom = Zoom
            return when (animationKey) {
                ZOOM_IN_DOWN -> zoom.inDown(view, animatorSet)
                ZOOM_IN_UP -> zoom.inUp(view, animatorSet)
                ZOOM_IN_LEFT -> zoom.inLeft(view, animatorSet)
                ZOOM_IN_RIGHT -> zoom.inRight(view, animatorSet)
                ZOOM_OUT_DOWN -> zoom.outDown(view, animatorSet)
                ZOOM_OUT_UP -> zoom.outUp(view, animatorSet)
                ZOOM_OUT_LEFT -> zoom.outLeft(view, animatorSet)
                ZOOM_OUT_RIGHT -> zoom.outRight(view, animatorSet)
                ZOOM_IN -> zoom.`in`(view, animatorSet)
                ZOOM_OUT -> zoom.out(view, animatorSet)
                else -> zoom.inDown(view, animatorSet)
            }
        }
        else -> Attention.bounce(view, AnimationX().getNewAnimatorSet())
    }

}