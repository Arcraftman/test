package com.aoding.mall.mapper;

import com.aoding.mall.model.CmsPreferenceAreaExample;

import java.util.List;

public interface CmsPreferenceArea {

    long countByExample(CmsPreferenceAreaExample example);

    List<CmsPreferenceArea> selectByExample(CmsPreferenceAreaExample example);

    List<CmsPreferenceArea> selectByExampleWithPic(CmsPreferenceAreaExample example);


}
