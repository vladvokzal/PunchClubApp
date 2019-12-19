package ru.nsu.lightweight.punchclub.utils

import android.content.Intent
import android.view.View
import androidx.fragment.app.FragmentActivity
import java.util.Timer
import java.util.TimerTask

class RouterUtil {

    companion object {

        /*
        * Call this method if you want to start the activity by clicking on the button
        * This method is protected from double button triggering
        * */
        fun onceClickListener(view: View?, listener: () -> Unit) {
            view ?: return
            view.setOnClickListener {
                view.setOnClickListener(null)
                Timer().schedule(object : TimerTask() {
                    override fun run() {
                        onceClickListener(view, listener)
                    }
                }, 1000)
                listener.invoke()
            }
        }

        fun startIntent(
            intent: Intent,
            activity: FragmentActivity?,
            animation: Animation
        ) {
            activity ?: return
            activity.startActivity(intent)
            setCustomAnimation(activity, animation)
        }

        fun startActivity(
            activity: FragmentActivity?,
            cls: Class<*>,
            animation: Animation = Animation.DEFAULT
        ) {
            activity ?: return
            val intent = Intent(activity, cls)
            startIntent(intent, activity, animation)
        }

        fun startActivityNoHistory(
            activity: FragmentActivity?,
            cls: Class<*>
        ) {
            activity ?: return
            val intent = Intent(activity, cls)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                    Intent.FLAG_ACTIVITY_CLEAR_TASK or
                    Intent.FLAG_ACTIVITY_NO_ANIMATION
            startIntent(intent, activity, Animation.NO_ANIMATION)
        }

        fun startActivityForResult(
            activity: FragmentActivity?,
            cls: Class<*>,
            animation: Animation = Animation.DEFAULT
        ) {
            activity ?: return
            val intent = Intent(activity, cls)
            activity.startActivityForResult(intent, 0)
            setCustomAnimation(activity, animation)
        }

        fun setCustomAnimation(activity: FragmentActivity, animation: Animation) {
            if (animation != Animation.NO_ANIMATION) {
                val (inAnim, outAnim) = Animation.getAnimationPair(animation)
                activity.overridePendingTransition(inAnim, outAnim)
            }
        }
    }
}