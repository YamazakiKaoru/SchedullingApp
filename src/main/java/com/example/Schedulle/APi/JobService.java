package com.example.Schedulle.APi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JobService {

	 @Autowired
	  @Qualifier("zipCodeSearchRestTemplate")
	  RestTemplate restTemplate;

    /** 求人サイトAPIのURL */
    private static final String URL = "https://job.yahooapis.jp/v1/furusato/jobinfo/?appid={appid}&start=1&results=1000&fields=full";

    private static String  appid = "dj00aiZpPUE0dWhOVFlyNUN5TiZzPWNvbnN1bWVyc2VjcmV0Jng9YWE-";
    public JobDto service() {
        return restTemplate.getForObject(URL, JobDto.class, appid);
    }

}