package com.amijiaoyu.babybus.android.ui.home

/**
 * @author Dsh  on 2018/4/8.
 */
enum class Status(val i: Int, val s: String) {

    UN_START(0, "0"),
    UN_PAY(1, "1"),
    UN_BEGIN(2, "2"),
    UN_KNOW(3, "3");


    companion object {
        fun getStatus(status: Int): String {
            return values()
                .firstOrNull { it.i == status }
                ?.s
                ?: UN_KNOW.s
        }
    }
}


