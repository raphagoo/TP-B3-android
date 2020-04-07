package com.example.tp.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.tp.models.Contact;

import java.util.List;

@Dao
public interface ContactDao {
    @Query("SELECT * FROM contact_table")
    List<Contact> getAll();

    @Query("DELETE FROM contact_table")
    void deleteAll();

    @Insert
    void insertAll(Contact... Contacts);

    @Delete
    void delete(Contact Contact);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void update(Contact contact);

}
