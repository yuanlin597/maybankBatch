package com.example.restservice.config;

import com.example.restservice.TransactionDetailsProcessor;
import com.example.restservice.TransactionDetailsWriter;
import com.example.restservice.entity.TransactionDetails;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class BatchJobConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public FlatFileItemReader readDataFile(){
        return new FlatFileItemReaderBuilder<TransactionDetails>()
                .name("transactionDataReader")
                .resource(new ClassPathResource("dataSource.txt"))
                .delimited().delimiter("|")
                .names(new String[]{"accountNumber", "trxAmount","description","trxDate","trxTime","customerId"})
                .linesToSkip(1)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<TransactionDetails>(){{
                    setTargetType(TransactionDetails.class);
                }})
                .build();
    }

    @Bean
    public TransactionDetailsProcessor processTransactionDetails(){
        return new TransactionDetailsProcessor();
    }

    @Bean
    public TransactionDetailsWriter writeTransactionDetails(){
        return new TransactionDetailsWriter();
    }

    @Bean
    public Job importUserJob(){
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .start(step())
                .build();

    }

    @Bean
    public Step step(){
        return stepBuilderFactory.get("step")
                .chunk(1)
                .reader(readDataFile())
                .processor(processTransactionDetails())
                .writer(writeTransactionDetails())
                .build();
    }
}
