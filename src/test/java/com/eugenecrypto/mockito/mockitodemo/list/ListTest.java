package com.eugenecrypto.mockito.mockitodemo.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    void simpleTest(){

        List list = mock(List.class);
        when(list.size()).thenReturn(3);

        assertEquals(3,list.size());
    }

    @Test
    void multipleReturnsTest(){
        List list = mock(List.class);

        when(list.size()).thenReturn(2).thenReturn(4).thenReturn(0);
        assertEquals(2,list.size()); //Success ( return 2 at first call )
        assertEquals(4,list.size()); //Success ( return 4 at second call )
        assertEquals(0,list.size()); //Success ( return 0 at third call and all next call)
        assertEquals(0,list.size()); //Success ( return 0 at fourth call and all next call )
    }

    @Test
    void genericParametersTest(){
        List list = mock(List.class);
        when(list.get(Mockito.anyInt())).thenReturn(3);
        assertEquals(3,list.get(2)); //Success ( return 3 at every call )
        assertEquals(3,list.get(4)); //Success
        assertEquals(3,list.get(5)); //Success
        assertEquals(3,list.get(3)); //Success
    }


    @Test
    void specificParameterTest(){
        List list = mock(List.class);
        when(list.get(2)).thenReturn(3);

        assertEquals(null,list.get(4)); //Success // Return null
        assertEquals(3,list.get(2)); //Success ( return 3 at every call with 2 as parameter )
    }




}
