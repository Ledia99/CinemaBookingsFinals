package CinemaBookingsFinal.Service.impl;

import CinemaBookingsFinal.Domain.dto.Screening.ScreeningDTO;
import CinemaBookingsFinal.Domain.entity.Screening;
import CinemaBookingsFinal.Domain.exception.ResourceNotFoundException;
import CinemaBookingsFinal.Domain.mapper.ScreeningMapper;
import CinemaBookingsFinal.Repository.ScreeningRepository;
import CinemaBookingsFinal.Service.ScreeningService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScreeningServiceImpl implements ScreeningService {
    private final ScreeningRepository screeningRepository;

    @Override
    public List<ScreeningDTO> getAllScreenings() {
        return screeningRepository.findAll().stream().map(ScreeningMapper::toDto).collect(Collectors.toList());
    }
    public Screening getScreeningById(Integer id){
        return screeningRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String
                        .format("Screening with id %s not found",id)));

    }
    @Override
    public ScreeningDTO addScreening( ScreeningDTO screeningDTO) {
        Screening screening = screeningRepository.findById(screeningDTO.getId()).orElse(null);
                if(screening != null){throw new ResourceNotFoundException(String.format("Screening exists"));}
        return ScreeningMapper.toDto(screeningRepository.save(ScreeningMapper.toEntity(screeningDTO)));
    }


}
