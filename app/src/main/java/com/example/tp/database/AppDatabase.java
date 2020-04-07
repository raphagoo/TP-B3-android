package com.example.tp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.tp.MainActivity;
import com.example.tp.database.dao.ContactDao;
import com.example.tp.models.Contact;

    @Database(entities = {Contact.class}, version = 1)
    public abstract class AppDatabase extends RoomDatabase {
        private static AppDatabase INSTANCE;
        private static Context ctx;

        public static AppDatabase getInstance(Context context) {
            ctx = context;
            if (INSTANCE == null) {
                synchronized (AppDatabase.class) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                AppDatabase.class, "MyDatabase.db")
                                .build();
                    }
                }
            }
            return INSTANCE;
        }

        // TODO : Handle the migrations: see examples below. Source : https://developer.android.com/training/data-storage/room/migrating-db-versions

    //    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
    //        @Override
    //        public void migrate(SupportSQLiteDatabase database) {
    //            database.execSQL("CREATE TABLE `Fruit` (`id` INTEGER, "
    //                    + "`name` TEXT, PRIMARY KEY(`id`))");
    //        }
    //    };

    //    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
    //        @Override
    //        public void migrate(SupportSQLiteDatabase database) {
    //            database.execSQL("ALTER TABLE Book "
    //                    + " ADD COLUMN pub_year INTEGER");
    //        }
    //    };

    // Room.databaseBuilder(getApplicationContext(), MyDb.class, "database-name").addMigrations(MIGRATION_1_2, MIGRATION_2_3).build();

        public abstract ContactDao contactDao();
    }
