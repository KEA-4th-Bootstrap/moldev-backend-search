package org.bootstrap.search.document;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record Post (
        String title,
        String content,
        String post_id,
        String member_id,
        String thumbnail,
        String Table,
        String last_modified_date,
        String id,
        String category,
        String create_date,
        String _timestamp,
        String view_count,
        String moldev_id
){

}
