package com.lorenzo.system.Operation;

import java.util.ArrayList;
import java.util.Scanner;

public interface BasicOperation {
    // 增
    void addInfo(Scanner sc, ArrayList list);

    // 删
    void deleteInfo(Scanner sc,ArrayList list);

    // 改
    void updateInfo(Scanner sc,ArrayList list);

    // 查
    void findAll(ArrayList list);
}
