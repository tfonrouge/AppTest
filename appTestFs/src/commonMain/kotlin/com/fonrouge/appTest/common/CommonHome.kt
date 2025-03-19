package com.fonrouge.appTest.common

import com.fonrouge.fsLib.common.ICommon
import com.fonrouge.fsLib.model.apiData.ApiFilter

data object CommonHome : ICommon<ApiFilter>(
    label = "Home",
    apiFilterSerializer = ApiFilter.serializer()
)
