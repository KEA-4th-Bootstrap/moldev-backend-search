package org.bootstrap.search.common;

import lombok.Builder;
import org.springframework.data.domain.Slice;

import static org.bootstrap.search.utils.EntityUpdateValueUtils.updateValue;

@Builder
public record PageInfo (
        Boolean hasNextPage,
        Integer pageNumber
){
    public static PageInfo of(Slice<?> page) {
        return PageInfo.builder()
                .hasNextPage(updateValue(null, page.hasNext()))
                .pageNumber(updateValue(null, page.getNumber()))
                .build();
    }
}
