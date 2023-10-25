package com.forceupdatekit.view.config

import com.forceupdatekit.view.ui.ForceUpdateViewFullScreen2
import com.forceupdatekit.view.ui.ForceUpdateViewFullScreen3
import com.forceupdatekit.view.ui.ForceUpdateViewFullScreen4
import com.forceupdatekit.view.ui.ForceUpdateViewPopover1
import com.forceupdatekit.view.ui.ForceUpdateViewPopover2
import com.forceupdatekit.view.ui.ForceUpdateViewFullScreen1


enum class ForceUpdateViewStyle() {
    FullScreen1,
    FullScreen2,
    FullScreen3,
    FullScreen4,
    Popover1,
    Popover2;
    companion object {
        fun checkViewStyle(style:ForceUpdateViewStyle):ForceUpdateViewContract {
            return when (style) {
                FullScreen1 -> ForceUpdateViewFullScreen1()
                FullScreen2 -> ForceUpdateViewFullScreen2()
                FullScreen3 -> ForceUpdateViewFullScreen3()
                FullScreen4 -> ForceUpdateViewFullScreen4()
                Popover1 -> ForceUpdateViewPopover1()
                Popover2 -> ForceUpdateViewPopover2()
            }

        }

    }

}
