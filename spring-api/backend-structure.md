spring-api/
├── pom.xml                                                       # Parent Maven POM file
│
├── spring-domain/                                                  # Shared domain layer
│   ├── pom.xml                                                   # Domain module POM
│   └── src/
│       ├── main/
│       │   ├── java/
│       │   │   └── com/
│       │   │       └── nvbinhsoft/
│       │   │           └── blog/
│       │   │               └── domain/
│       │   │                   ├── model/                        # Domain models (write models)
│       │   │                   │   ├── article/
│       │   │                   │   │   ├── Article.java          # Core article entity
│       │   │                   │   │   ├── ArticleContent.java   # Value object for content
│       │   │                   │   │   ├── ArticleId.java        # ID value object
│       │   │                   │   │   └── ArticleStatus.java    # Status enumeration
│       │   │                   │   ├── category/
│       │   │                   │   │   ├── Category.java         # Category entity
│       │   │                   │   │   └── CategoryId.java       # ID value object
│       │   │                   │   ├── comment/
│       │   │                   │   │   ├── Comment.java          # Comment entity
│       │   │                   │   │   └── CommentId.java        # ID value object
│       │   │                   │   ├── tag/
│       │   │                   │   │   ├── Tag.java              # Tag entity
│       │   │                   │   │   └── TagId.java            # ID value object
│       │   │                   │   ├── user/
│       │   │                   │   │   ├── User.java             # User entity
│       │   │                   │   │   └── UserId.java           # ID value object
│       │   │                   │   └── common/
│       │   │                   │       ├── AggregateRoot.java    # Base class for aggregates
│       │   │                   │       ├── Email.java            # Email value object
│       │   │                   │       └── Slug.java             # Slug value object
│       │   │                   │
│       │   │                   ├── event/                        # Domain events
│       │   │                   │   ├── DomainEvent.java          # Base domain event interface
│       │   │                   │   ├── article/
│       │   │                   │   │   ├── ArticleCreatedEvent.java
│       │   │                   │   │   ├── ArticlePublishedEvent.java
│       │   │                   │   │   └── ArticleUpdatedEvent.java
│       │   │                   │   ├── comment/
│       │   │                   │   │   ├── CommentAddedEvent.java
│       │   │                   │   │   └── CommentApprovedEvent.java
│       │   │                   │   └── subscriber/
│       │   │                   │       └── SubscriberAddedEvent.java
│       │   │                   │
│       │   │                   ├── repository/                   # Repository interfaces
│       │   │                   │   ├── ArticleRepository.java
│       │   │                   │   ├── CategoryRepository.java
│       │   │                   │   ├── CommentRepository.java
│       │   │                   │   ├── TagRepository.java
│       │   │                   │   ├── UserRepository.java
│       │   │                   │   └── SubscriberRepository.java
│       │   │                   │
│       │   │                   ├── service/                      # Domain services
│       │   │                   │   ├── SlugGenerationService.java
│       │   │                   │   └── PasswordHashService.java
│       │   │                   │
│       │   │                   └── exception/                    # Domain exceptions
│       │   │                       ├── DomainException.java
│       │   │                       ├── ArticleNotFoundException.java
│       │   │                       └── InvalidSlugException.java
│       │   │
│       │   └── resources/                                        # Domain resources
│       │
│       └── test/                                                 # Domain tests
│           └── java/
│               └── com/
│                   └── nvbinhsoft/
│                       └── blog/
│                           └── domain/
│                               └── model/
│                                   ├── article/
│                                   │   └── ArticleTest.java
│                                   └── ...
│
├── spring-command-api/                                             # Command API (Write operations)
│   ├── pom.xml                                                   # Command API module POM
│   └── src/
│       ├── main/
│       │   ├── java/
│       │   │   └── com/
│       │   │       └── nvbinhsoft/
│       │   │           └── blog/
│       │   │               └── command/
│       │   │                   ├── BlogCommandApplication.java   # Command application entry point
│       │   │                   │
│       │   │                   ├── api/                          # Command API controllers
│       │   │                   │   ├── article/
│       │   │                   │   │   └── ArticleCommandController.java
│       │   │                   │   ├── category/
│       │   │                   │   │   └── CategoryCommandController.java
│       │   │                   │   ├── comment/
│       │   │                   │   │   └── CommentCommandController.java
│       │   │                   │   ├── tag/
│       │   │                   │   │   └── TagCommandController.java
│       │   │                   │   ├── user/
│       │   │                   │   │   └── UserCommandController.java
│       │   │                   │   └── subscriber/
│       │   │                   │       └── SubscriberCommandController.java
│       │   │                   │
│       │   │                   ├── application/                  # Command handlers
│       │   │                   │   ├── article/
│       │   │                   │   │   ├── command/
│       │   │                   │   │   │   ├── CreateArticleCommand.java
│       │   │                   │   │   │   ├── UpdateArticleCommand.java
│       │   │                   │   │   │   └── PublishArticleCommand.java
│       │   │                   │   │   └── handler/
│       │   │                   │   │       └── ArticleCommandHandler.java
│       │   │                   │   ├── category/
│       │   │                   │   ├── comment/
│       │   │                   │   ├── tag/
│       │   │                   │   ├── user/
│       │   │                   │   └── subscriber/
│       │   │                   │
│       │   │                   ├── config/                       # Command-specific configs
│       │   │                   │   ├── CommandDataSourceConfig.java
│       │   │                   │   ├── CommandSecurityConfig.java
│       │   │                   │   └── CommandSwaggerConfig.java
│       │   │                   │
│       │   │                   └── dto/                          # Command DTOs
│       │   │                       ├── request/
│       │   │                       │   ├── CreateArticleRequest.java
│       │   │                       │   ├── UpdateArticleRequest.java
│       │   │                       │   └── ...
│       │   │                       └── response/
│       │   │                           ├── CommandResponse.java
│       │   │                           └── ...
│       │   │
│       │   └── resources/
│       │       ├── application.yml                               # Command API properties
│       │       ├── application-dev.yml
│       │       └── application-prod.yml
│       │
│       └── test/                                                 # Command API tests
│           └── java/
│               └── com/
│                   └── nvbinhsoft/
│                       └── blog/
│                           └── command/
│                               └── api/
│                                   └── article/
│                                       └── ArticleCommandControllerTest.java
│
├── spring-query-api/                                               # Query API (Read operations)
│   ├── pom.xml                                                   # Query API module POM
│   └── src/
│       ├── main/
│       │   ├── java/
│       │   │   └── com/
│       │   │       └── nvbinhsoft/
│       │   │           └── blog/
│       │   │               └── query/
│       │   │                   ├── BlogQueryApplication.java     # Query application entry point
│       │   │                   │
│       │   │                   ├── api/                          # Query API controllers
│       │   │                   │   ├── article/
│       │   │                   │   │   └── ArticleQueryController.java
│       │   │                   │   ├── category/
│       │   │                   │   │   └── CategoryQueryController.java
│       │   │                   │   ├── comment/
│       │   │                   │   │   └── CommentQueryController.java
│       │   │                   │   ├── tag/
│       │   │                   │   │   └── TagQueryController.java
│       │   │                   │   ├── user/
│       │   │                   │   │   └── UserQueryController.java
│       │   │                   │   ├── subscriber/
│       │   │                   │   │   └── SubscriberQueryController.java
│       │   │                   │   └── statistics/
│       │   │                   │       └── StatisticsQueryController.java
│       │   │                   │
│       │   │                   ├── application/                  # Query handlers
│       │   │                   │   ├── article/
│       │   │                   │   │   ├── query/
│       │   │                   │   │   │   ├── GetArticleQuery.java
│       │   │                   │   │   │   ├── ListArticlesQuery.java
│       │   │                   │   │   │   └── GetArticlesByCategoryQuery.java
│       │   │                   │   │   └── handler/
│       │   │                   │   │       └── ArticleQueryHandler.java
│       │   │                   │   ├── category/
│       │   │                   │   ├── comment/
│       │   │                   │   ├── tag/
│       │   │                   │   ├── user/
│       │   │                   │   └── statistics/
│       │   │                   │
│       │   │                   ├── config/                       # Query-specific configs
│       │   │                   │   ├── QueryDataSourceConfig.java
│       │   │                   │   ├── QuerySecurityConfig.java
│       │   │                   │   ├── CacheConfig.java
│       │   │                   │   └── QuerySwaggerConfig.java
│       │   │                   │
│       │   │                   ├── dto/                          # Query response DTOs
│       │   │                   │   ├── ArticleView.java          # Read model for articles
│       │   │                   │   ├── ArticleDetailView.java    # Detailed article view
│       │   │                   │   ├── HomePageView.java         # Home page data
│       │   │                   │   ├── CategoryView.java
│       │   │                   │   └── ...
│       │   │                   │
│       │   │                   ├── repository/                   # Query repositories
│       │   │                   │   ├── ArticleViewRepository.java
│       │   │                   │   ├── HomePageViewRepository.java
│       │   │                   │   ├── CategoryViewRepository.java
│       │   │                   │   └── ...
│       │   │                   │
│       │   │                   ├── projector/                    # Read model event handlers
│       │   │                   │   ├── ArticleProjector.java
│       │   │                   │   ├── CommentProjector.java
│       │   │                   │   └── ...
│       │   │                   │
│       │   │                   └── model/                        # Read models (database entities)
│       │   │                       ├── ArticleViewModel.java
│       │   │                       ├── CategoryViewModel.java
│       │   │                       ├── HomePageViewModel.java
│       │   │                       └── ...
│       │   │
│       │   └── resources/
│       │       ├── application.yml                               # Query API properties
│       │       ├── application-dev.yml
│       │       └── application-prod.yml
│       │
│       └── test/                                                 # Query API tests
│           └── java/
│               └── com/
│                   └── nvbinhsoft/
│                       └── blog/
│                           └── query/
│                               └── api/
│                                   └── article/
│                                       └── ArticleQueryControllerTest.java
│
├── spring-infrastructure/                                          # Shared infrastructure
│   ├── pom.xml                                                   # Infrastructure module POM
│   └── src/
│       ├── main/
│       │   ├── java/
│       │   │   └── com/
│       │   │       └── nvbinhsoft/
│       │   │           └── blog/
│       │   │               └── infrastructure/
│       │   │                   ├── config/                       # Common configurations
│       │   │                   │   ├── JwtConfig.java
│       │   │                   │   ├── WebConfig.java
│       │   │                   │   └── AsyncConfig.java
│       │   │                   │
│       │   │                   ├── persistence/                  # Database implementations
│       │   │                   │   ├── command/                  # Write side persistence
│       │   │                   │   │   ├── entity/
│       │   │                   │   │   │   ├── ArticleEntity.java
│       │   │                   │   │   │   ├── CategoryEntity.java
│       │   │                   │   │   │   └── ...
│       │   │                   │   │   ├── repository/
│       │   │                   │   │   │   ├── SpringArticleRepository.java
│       │   │                   │   │   │   ├── SpringCategoryRepository.java
│       │   │                   │   │   │   └── ...
│       │   │                   │   │   └── adapter/
│       │   │                   │   │       ├── JpaArticleRepository.java
│       │   │                   │   │       ├── JpaCategoryRepository.java
│       │   │                   │   │       └── ...
│       │   │                   │   │
│       │   │                   │   └── query/                    # Read side persistence
│       │   │                   │       ├── entity/
│       │   │                   │       │   ├── ArticleViewEntity.java
│       │   │                   │       │   ├── CategoryViewEntity.java
│       │   │                   │       │   └── ...
│       │   │                   │       ├── repository/
│       │   │                   │       │   ├── SpringArticleViewRepository.java
│       │   │                   │       │   ├── SpringCategoryViewRepository.java
│       │   │                   │       │   └── ...
│       │   │                   │       └── adapter/
│       │   │                   │           ├── JpaArticleViewRepository.java
│       │   │                   │           ├── JpaCategoryViewRepository.java
│       │   │                   │           └── ...
│       │   │                   │
│       │   │                   ├── messaging/                    # Messaging infrastructure
│       │   │                   │   ├── kafka/                    # Kafka implementation
│       │   │                   │   │   ├── KafkaConfig.java
│       │   │                   │   │   └── KafkaEventPublisher.java
│       │   │                   │   ├── rabbitmq/                 # RabbitMQ implementation
│       │   │                   │   │   ├── RabbitConfig.java
│       │   │                   │   │   └── RabbitEventPublisher.java
│       │   │                   │   └── local/                    # In-memory implementation
│       │   │                   │       └── LocalEventPublisher.java
│       │   │                   │
│       │   │                   ├── security/                     # Security implementation
│       │   │                   │   ├── JwtTokenProvider.java
│       │   │                   │   ├── UserDetailsServiceImpl.java
│       │   │                   │   └── AuthenticationFacade.java
│       │   │                   │
│       │   │                   ├── storage/                      # File storage
│       │   │                   │   ├── FileStorageService.java
│       │   │                   │   ├── local/
│       │   │                   │   │   └── LocalFileStorage.java
│       │   │                   │   └── s3/
│       │   │                   │       └── S3FileStorage.java
│       │   │                   │
│       │   │                   ├── email/                        # Email services
│       │   │                   │   ├── EmailService.java
│       │   │                   │   ├── template/
│       │   │                   │   │   ├── SubscriptionTemplate.java
│       │   │                   │   │   └── NotificationTemplate.java
│       │   │                   │   └── smtp/
│       │   │                   │       └── SmtpEmailService.java
│       │   │                   │
│       │   │                   └── cache/                        # Caching
│       │   │                       ├── CacheService.java
│       │   │                       └── redis/
│       │   │                           └── RedisCacheService.java
│       │   │
│       │   └── resources/
│       │       └── infrastructure-common.properties
│       │
│       └── test/                                                 # Infrastructure tests
│           └── java/
│               └── com/
│                   └── nvbinhsoft/
│                       └── blog/
│                           └── infrastructure/
│                               └── persistence/
│                                   └── JpaArticleRepositoryTest.java
│
├── spring-api-gateway/                                             # API Gateway (optional)
│   ├── pom.xml                                                   # API Gateway module POM
│   └── src/
│       ├── main/
│       │   ├── java/
│       │   │   └── com/
│       │   │       └── nvbinhsoft/
│       │   │           └── blog/
│       │   │               └── gateway/
│       │   │                   ├── BlogGatewayApplication.java   # Gateway application entry point
│       │   │                   └── config/
│       │   │                       ├── GatewayConfig.java
│       │   │                       ├── CorsConfig.java
│       │   │                       └── SecurityConfig.java
│       │   │
│       │   └── resources/
│       │       └── application.yml                               # Gateway properties
│       │
│       └── test/
│           └── java/
│               └── com/
│                   └── nvbinhsoft/
│                       └── blog/
│                           └── gateway/
│                               └── GatewayIntegrationTest.java
│
├── spring-migration/                                               # Database migrations
│   ├── pom.xml                                                   # Migration module POM
│   └── src/
│       └── main/
│           └── resources/
│               └── db/
│                   └── migration/
│                       ├── V1__initial_schema.sql                # Base schema
│                       ├── V2__command_tables.sql                # Write model tables
│                       ├── V3__query_tables.sql                  # Read model tables
│                       └── V4__materialized_views.sql            # Materialized views
│