package com.yupi.usercenter.model.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class DeleteRequest implements Serializable {
    private static final long serialVersionUID = -6308299489760623087L;
    /**
     * 队伍 id
     */
    private long teamId;
}
