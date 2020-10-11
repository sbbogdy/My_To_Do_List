package com.example.my_to_do_list

import java.io.FileDescriptor

class Task {
    var id : Int = 0
    var task : String = ""
    var description : String = ""

    constructor(task:String,description:String)
    {
        this.task = task
        this.description = description
    }
    constructor(){

    }
}