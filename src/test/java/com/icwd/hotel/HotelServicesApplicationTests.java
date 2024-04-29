package com.icwd.hotel;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import com.icwd.hotel.entities.Hotel;
import com.icwd.hotel.repositories.HotelServiceRepository;


@SpringBootTest(classes = HotelServicesApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ContextConfiguration
class HotelServicesApplicationTests {

	@Autowired
	private HotelServiceRepository hotelServiceRepository;
	

	@Test
	@Order(1)
	void contextLoads() {
	} 

    @Test
    @Order(2)
    @Rollback(value = false)
    public void testCreateHotel() {
    	Hotel hotel = new Hotel("1","Radisson Blu","Gurgaon","Best Hotel");
    	hotelServiceRepository.save(hotel);
        assertNotNull(hotel.getId());
    }
    
    @Test
    @Order(3)
    public void testGetAllHotels(){
    	List<Hotel> list = hotelServiceRepository.findAll();
        Assertions.assertThat(list.size()).isGreaterThan(0);
    }


    @Test
    @Order(4)
    public void testGetHotelById() {   	
    	Optional<Hotel> ht = hotelServiceRepository.findById("1");
    	Assertions.assertThat(ht.isEmpty());
    }

}
