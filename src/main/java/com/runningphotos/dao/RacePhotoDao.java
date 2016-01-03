package com.runningphotos.dao;


import com.runningphotos.bom.RacePhoto;

import java.util.List;

/**
 * Created by zOpa on 21.12.2015.
 */
public interface RacePhotoDao extends MyBatisDao<RacePhoto>{

    List<RacePhoto> getAllAuthorPhotos(int authorId);
}
