package com.notebook.config;

import com.notebook.pojo.ImageNote;
import com.notebook.pojo.Note;
import com.notebook.pojo.NoteBook;
import com.notebook.pojo.TextNote;
import com.notebook.serviceImpl.NoteBookServiceImpl;
import com.notebook.serviceImpl.NoteServiceImpl;
import com.notebook.services.NoteBookService;
import com.notebook.services.NoteService;
import org.h2.jdbcx.JdbcDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Context configuration(bean creation)
 * @author Владислав
 * @version 1.0
 */
@Configuration
@ComponentScan
@EnableJpaRepositories(basePackages = "com.notebook.repositories")
@EnableTransactionManagement
public class ContextConfig {

    /**
     * Create NoteBook bean
     * @return NoteBook
     */
    @Bean("noteBook")
    public NoteBook noteBook() {
        return new NoteBook();
    }

    /**
     * Create Note bean
     * @return Note
     */
    @Bean("note")
    public Note note() {
        return new Note();
    }

    /**
     * Create TextNote bean
     * @return TextNote
     */
    @Bean("textNote")
    public TextNote textNote(){
        return new TextNote();
    }

    /**
     * Create ImageNote bean
     * @return ImageNote
     */
    @Bean("imageNote")
    public ImageNote imageNote(){
        return new ImageNote();
    }

    /**
     * Create NoteBookService bean
     * @return NoteBookServiceImpl
     */
    @Bean("noteBookService")
    public NoteBookService noteBookService(){
        return new NoteBookServiceImpl();
    }

    /**
     * Create NoteService bean
     * @return NoteService
     */
    @Bean("myNoteService")
    public NoteService noteService(){
        return new NoteServiceImpl();
    }

    /**
     * Create ApplicationContextProvider bean
     * @return ApplicationContextProvider
     */
    @Bean
    public ApplicationContextProvider applicationContextProvider(){
        return new ApplicationContextProvider();
    }

    /**
     * Set dataBase provider
     * @return dataSource with H2 provider
     */
    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
    }

    /**
     * Set dataBase provider
     * @return JpaVendorAdapter with H2 provider
     */
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter bean = new HibernateJpaVendorAdapter();
        bean.setDatabase(Database.H2);
        bean.setGenerateDdl(true);
        return bean;
    }

    /**
     * Initialize connection pool
     * @param dataSource bean
     * @param jpaVendorAdapter bean
     * @return LocalContainerEntityManagerFactoryBean
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(dataSource);
        bean.setJpaVendorAdapter(jpaVendorAdapter);
        bean.setPackagesToScan("com.notebook.pojo");
        return bean;
    }

    /**
     * Initialize transactional manager
     * @param emf bean
     * @return JpaTransactionManager
     */
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
