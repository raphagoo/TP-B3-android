package com.example.tp.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BaseDao<T> {
        /**
         * Insert an object in the database.
         *
         * @param obj the object to be inserted.
         */
        @Insert
        long insert(T obj); // can return void

        /**
         * Insert an array of objects in the database.
         *
         * @param list the objects to be inserted.
         */
        @Insert
        List<Long> insertAll(T... list); // Can return void, List<Long>, long[] or Long[]

        /**
         * Update an object list of the database.
         *
         * @param list of objects to be updated
         */
        @Update
        void update(T... list); // can return int (the number of item updated)

        /**
         * Delete an object list from the database
         *
         * @param list of objects to be deleted
         */
        @Delete
        void delete(T... list); // can return int (the number of item updated)
}
