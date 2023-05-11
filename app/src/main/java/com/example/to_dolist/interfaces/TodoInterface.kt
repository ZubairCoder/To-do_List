package com.example.to_dolist.interfaces

import com.example.to_dolist.datamodel.DataModel

interface TodoInterface {
    fun onClick(dataModel: DataModel)
}