package com.swan.obj.song;

/**
 * 삭제기능이 추가된 {@link PersonalPlaylist}
 *
 */
public class PersonalPlaylist extends PlayList {
    public void remove(Song song) {
        getTracks().remove(song);
        //PlayList에 가수의 이름을 키로 저장 기능 생겨서 삭제기능을 추가해야 한다.
        getSingers().remove(song.getSinger());

    }
}
