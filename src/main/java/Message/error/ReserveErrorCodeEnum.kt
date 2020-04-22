package com.spc.base.error


enum class ReserveErrorCodeEnum(
    private val code: Int,
    private val msg: String
) {

    RL10020001(10020001, "目标信息不存在"),

    MG1003001(1003001,"预约信息更新失败"),

    MG1003002(1003002,"预约信息删除失败"),

    MG1003003(1003003,"预约信息查询失败"),

    MG1003004(1003004,"预约信息添加失败"),

    ;



    /**
     * Msg string.
     *
     * @return the string
     */
    fun msg(): String {
        return msg
    }

    /**
     * Code int.
     *
     * @return the int
     */
    fun code(): Int {
        return code
    }

    companion object {

        /**
         * Gets enum.
         *
         * @param code the status
         *
         * @return the enum
         */
        fun getEnum(code: Int?): ReserveErrorCodeEnum? {
            if (code == null) return null
            values().forEach {
                if (it.code == code) return it
            }
            return null
        }
    }
}