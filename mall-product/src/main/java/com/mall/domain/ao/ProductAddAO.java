package com.mall.domain.ao;

import cn.hutool.core.convert.Convert;
import com.mall.domain.entity.SkuDO;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ProductAddAO {

    /**
     * spu
     */
    private SpuAddAO spuAddAO;

    /**
     * sku
     */
    private List<SkuAddAO> skuAddAOList;

    public List<SkuDO> toSkuDOList(Long spuId) {
        return skuAddAOList.stream().map(ao -> {
            SkuDO convert = Convert.convert(SkuDO.class, ao);
            convert.setSpuId(spuId);
            return convert;
        }).collect(Collectors.toList());
    }
}
