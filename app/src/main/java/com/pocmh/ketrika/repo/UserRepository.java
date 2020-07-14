package com.pocmh.ketrika.repo;

import android.content.Context;

import androidx.lifecycle.LiveData;


import com.pocmh.ketrika.models.User;

import java.util.List;

import io.realm.Realm;

public class UserRepository {

    Realm realm;
    public UserRepository(Context context) {
        Realm.init(context);
        realm = Realm.getDefaultInstance();
    }

    public void Persist(User userToPersist) {
        realm.beginTransaction();
        User u = realm.copyToRealm(userToPersist);
        realm.commitTransaction();
    }

    public List<User> findAll() {
        return realm.where(User.class).findAll();
    }

    public User find(String fieldName, String valueToFind) {
        return realm.where(User.class).equalTo(fieldName, valueToFind).findFirst();
    }

    public void updateUser(String code, User userEdited) {
        User user = realm.where(User.class).equalTo("code", code).findFirst();
        realm.beginTransaction();
        user = realm.copyToRealm(userEdited);
        realm.commitTransaction();
    }

    public Realm getRealm() {
        return realm;
    }

    public void setRealm(Realm realm) {
        this.realm = realm;
    }
}
