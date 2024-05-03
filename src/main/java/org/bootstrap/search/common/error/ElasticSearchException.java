package org.bootstrap.search.common.error;

public class ElasticSearchException extends BaseErrorException{
    public ElasticSearchException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
