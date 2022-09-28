package com.cricinfo.core.xml.model;

import com.cricinfo.core.xml.base.BaseObject;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@NoArgsConstructor
@XmlRootElement(name = "rss")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
public class LiveScoreXML extends BaseObject {

    private static final long serialVersionUID = 2948695271263745888L;

    @XmlElement(name = "channel")
    private Channel channel;

    @NoArgsConstructor
    @Getter
    public static class Channel extends BaseObject {

        private static final long serialVersionUID = -7663938333969209702L;

        @XmlElement(name = "title")
        private String title;

        @XmlElement(name = "ttl")
        private String ttl;

        @XmlElement(name = "link")
        private String link;

        @XmlElement(name = "description")
        private String description;

        @XmlElement(name = "copyright")
        private String copyright;

        @XmlElement(name = "language")
        private String language;

        @XmlElement(name = "pubDate")
        private String pubDate;

        @XmlElement(name = "item")
        private List<Item> item;

        @NoArgsConstructor
        @Getter
        public static class Item extends BaseObject {

            private static final long serialVersionUID = -6672838742148524285L;

            @XmlElement(name = "title")
            private String title;

            @XmlElement(name = "link")
            private String link;

            @XmlElement(name = "description")
            private String description;

            @XmlElement(name = "guid")
            private String guid;

        }
    }
}
