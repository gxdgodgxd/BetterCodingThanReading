package com.gxd.common;

import lombok.Builder;
import lombok.Data;

/**
 * Created by guoxd on 2019/8/27.
 */
@Data
@Builder
public class BinaryTreeNode {

    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

}
