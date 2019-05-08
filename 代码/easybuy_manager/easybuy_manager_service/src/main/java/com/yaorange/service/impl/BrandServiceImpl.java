package com.yaorange.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yaorange.mapper.TBrandMapper;
import com.yaorange.pojo.TBrand;
import com.yaorange.pojo.TBrandExample;
import com.yaorange.service.BrandService;
import com.yaorange.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.ElementType;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private TBrandMapper mapper;
    @Override
    public List<TBrand> data(String q) {
        TBrandExample example = new TBrandExample();
        if(q!=null&&!q.equals("")){
            TBrandExample.Criteria criteria = example.createCriteria();
            criteria.andEnglishNameLike("%"+q+"%");
        }
        List<TBrand> list = mapper.selectByExample(example);
        return list;
    }

    @Override
    public Page<TBrand> getTbrand(Integer page, Integer rows) {
        Page<TBrand> page1 = new Page();
        TBrandExample example = new TBrandExample();
        example.setOrderByClause("create_time desc");
        PageHelper.startPage(page,rows);
        List<TBrand> list = mapper.selectByExample(example);
        PageInfo<TBrand> pageInfo = new PageInfo<>(list);
        page1.setTotal((int) pageInfo.getTotal());
        page1.setRows(list);
        return page1;
    }

    @Override
    public void saveBrand(TBrand tBrand) {
        //没有ID 执行保存的操作
        if(tBrand.getId()==null&&!tBrand.getId().equals("")){
        tBrand.setCreateTime(System.currentTimeMillis());
        tBrand.setUpdateTime(System.currentTimeMillis());
        tBrand.setFirstLetter("N");
        mapper.insert(tBrand);
        }else {
            //有id的话 执行更新操作
            mapper.updateByPrimaryKeySelective(tBrand);
        }
    }

    @Override
    public TBrand getDetail(String id) {
        TBrand tBrand = mapper.selectByPrimaryKey(Long.parseLong(id));
        return tBrand;
    }
}
