package ru.nsu.lightweight.punchclub.utils

import ru.nsu.lightweight.punchclub.R

enum class Animation {
    NO_ANIMATION,
    DEFAULT,
    SLIDE_IN,
    SLIDE_OUT,
    LONG_FADE;

    companion object {

        fun getAnimationPair(animation: Animation): Pair<Int, Int> {
            return when (animation) {
                NO_ANIMATION -> throw IllegalArgumentException("NO ANIMATION")
                DEFAULT -> R.anim.long_fade_in to R.anim.long_fade_out
                SLIDE_IN -> R.anim.slide_in_right to R.anim.slide_out_left
                SLIDE_OUT -> R.anim.slide_in_left to R.anim.slide_out_right
                LONG_FADE -> R.anim.long_fade_in to R.anim.long_fade_out
            }
        }
    }
}