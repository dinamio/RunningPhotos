package com.runningphotos.dao;

import com.runningphotos.bom.NumberOnPhoto;

import java.util.List;

/**
 * Created by Oleg on 20.03.2016.
 */
public interface NumberOnPhotoDao extends MyBatisDao<NumberOnPhoto> {

    void deleteAllByPhotoId(int id);

    List<NumberOnPhoto> selectAllByPhotoId(int id);

}
