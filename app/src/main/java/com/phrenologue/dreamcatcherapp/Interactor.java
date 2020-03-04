package com.phrenologue.dreamcatcherapp;
import com.phrenologue.dreamcatcherapp.parameters.Users;

public class Interactor {



    //----------------------------------- Post Parameters ------------------------------------------
    // A. Write Dreams.


    // B. Write Sleeps.

    // I. Write Sleeps to Sleeps' Cat.



    //----------------------------------- Date Parameters ------------------------------------------

    // 2. Write DateParameters into DB.

    // A. Write Days.

//=========================================== Read =================================================
    //----------------------------------- Post Parameters ------------------------------------------
    // A. Read Dreams.

    // B. Read Sleeps.
    //----------------------------------- Date Parameters ------------------------------------------
    // A. Read Days.
    // B. Read Weeks.
    // C. Read Months.
    // D. Read Years.
    public Integer getUid(){
        Users user = Users.getInstance();
        Integer uid = user.getUid();
        return uid;
    }
}
