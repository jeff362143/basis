package com.service;

import com.dao.imple.InformDao;
import com.pojo.Inform;

import java.util.List;

public class InformService extends InformDao {
    public int getInformCountService(String username) {
        return getInformCountByUsername(username);
    }

    public List<Inform> getInformService(String username) {
        return getInformByUsername(username);
    }

    public void sendLikeInfoService(Inform inform) {
        sendLikeInformForAuthor(inform);
    }
}
