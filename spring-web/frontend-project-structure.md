frontend/
│
├── .eslintrc.js                          # ESLint configuration
├── .prettierrc                           # Prettier configuration
├── .env                                  # Environment variables
├── .env.development                      # Development environment variables
├── .env.production                       # Production environment variables
├── .gitignore                            # Git ignore file
├── index.html                            # HTML entry point
├── package.json                          # NPM dependencies and scripts
├── tsconfig.json                         # TypeScript configuration
├── vite.config.ts                        # Vite configuration
├── tailwind.config.js                    # Tailwind CSS configuration
├── postcss.config.js                     # PostCSS configuration
├── README.md                             # Project documentation
│
├── public/                               # Static assets
│   ├── favicon.ico                       # Favicon
│   ├── robots.txt                        # Robots file for SEO
│   ├── logo.svg                          # Website logo
│   ├── manifest.json                     # PWA manifest
│   └── assets/                           # Other static assets
│       └── images/                       # Static images
│           ├── default-avatar.png        # Default user avatar
│           ├── placeholder.jpg           # Image placeholder
│           └── logo-dark.svg             # Dark mode logo
│
└── src/                                  # Application source code
├── main.tsx                          # Application entry point
├── App.tsx                           # Root component
├── vite-env.d.ts                     # Vite TypeScript declarations
│
├── types/                            # TypeScript type definitions
│   ├── index.ts                      # Type exports
│   ├── article.types.ts              # Article-related types
│   ├── user.types.ts                 # User-related types
│   ├── comment.types.ts              # Comment-related types
│   ├── category.types.ts             # Category-related types
│   ├── tag.types.ts                  # Tag-related types
│   ├── subscriber.types.ts           # Subscriber-related types
│   ├── form.types.ts                 # Form-related types
│   ├── api.types.ts                  # API-related types
│   └── common.types.ts               # Common utility types
│
├── assets/                           # Local assets
│   ├── images/                       # Image assets
│   │   ├── icons/                    # Icon assets
│   │   └── backgrounds/              # Background images
│   └── styles/                       # Global styles
│       ├── index.css                 # Main CSS entry
│       ├── tailwind.css              # Tailwind imports
│       ├── variables.css             # CSS variables
│       ├── typography.css            # Typography styles
│       ├── animations.css            # CSS animations
│       └── utils.css                 # Utility classes
│
├── config/                           # Application configuration
│   ├── api.config.ts                 # API endpoints configuration
│   ├── routes.config.ts              # Route definitions
│   ├── constants.ts                  # Application constants
│   ├── theme.config.ts               # Theme configuration
│   └── editor.config.ts              # Rich text editor configuration
│
├── lib/                              # Shared libraries
│   ├── api.ts                        # API client setup
│   ├── axios-instance.ts             # Axios instance with interceptors
│   ├── query-client.ts               # React Query client setup
│   ├── storage.ts                    # Local storage utilities
│   ├── markdown.ts                   # Markdown utilities
│   ├── analytics.ts                  # Analytics utilities
│   └── validation.ts                 # Form validation schemas
│
├── hooks/                            # Custom React hooks
│   ├── useAuth.ts                    # Authentication hook
│   ├── useArticles.ts                # Articles data hook
│   ├── useCategories.ts              # Categories data hook
│   ├── useTags.ts                    # Tags data hook
│   ├── useComments.ts                # Comments data hook
│   ├── useSubscribers.ts             # Subscribers data hook
│   ├── useUser.ts                    # User data hook
│   ├── useForm.ts                    # Form utilities
│   ├── useToast.ts                   # Toast notifications hook
│   ├── useOnClickOutside.ts          # Click outside hook
│   ├── useDebounce.ts                # Debounce hook
│   ├── useLocalStorage.ts            # Local storage hook
│   ├── useMediaQuery.ts              # Media query hook
│   ├── useScrollPosition.ts          # Scroll position hook
│   └── useCopyToClipboard.ts         # Copy to clipboard hook
│
├── context/                          # React context providers
│   ├── AuthContext.tsx               # Authentication context
│   ├── ThemeContext.tsx              # Theme context
│   ├── ToastContext.tsx              # Toast notifications context
│   ├── SidebarContext.tsx            # Sidebar state context
│   └── ModalContext.tsx              # Modal context
│
├── components/                       # Shared components
│   ├── ui/                           # UI components
│   │   ├── Button/
│   │   │   ├── Button.tsx            # Button component
│   │   │   ├── Button.module.css     # Button styles
│   │   │   ├── Button.test.tsx       # Button tests
│   │   │   └── index.ts              # Export file
│   │   ├── Input/
│   │   │   ├── Input.tsx             # Input component
│   │   │   ├── Input.module.css      # Input styles
│   │   │   ├── Input.test.tsx        # Input tests
│   │   │   └── index.ts              # Export file
│   │   ├── Select/
│   │   │   ├── Select.tsx            # Select component
│   │   │   ├── Select.module.css     # Select styles
│   │   │   ├── Select.test.tsx       # Select tests
│   │   │   └── index.ts              # Export file
│   │   ├── Card/
│   │   │   ├── Card.tsx              # Card component
│   │   │   ├── Card.module.css       # Card styles
│   │   │   ├── Card.test.tsx         # Card tests
│   │   │   └── index.ts              # Export file
│   │   ├── Alert/
│   │   │   ├── Alert.tsx             # Alert component
│   │   │   ├── Alert.module.css      # Alert styles
│   │   │   ├── Alert.test.tsx        # Alert tests
│   │   │   └── index.ts              # Export file
│   │   ├── Badge/
│   │   │   ├── Badge.tsx             # Badge component
│   │   │   ├── Badge.module.css      # Badge styles
│   │   │   ├── Badge.test.tsx        # Badge tests
│   │   │   └── index.ts              # Export file
│   │   ├── Avatar/
│   │   │   ├── Avatar.tsx            # Avatar component
│   │   │   ├── Avatar.module.css     # Avatar styles
│   │   │   ├── Avatar.test.tsx       # Avatar tests
│   │   │   └── index.ts              # Export file
│   │   ├── Modal/
│   │   │   ├── Modal.tsx             # Modal component
│   │   │   ├── Modal.module.css      # Modal styles
│   │   │   ├── Modal.test.tsx        # Modal tests
│   │   │   └── index.ts              # Export file
│   │   ├── Dropdown/
│   │   │   ├── Dropdown.tsx          # Dropdown component
│   │   │   ├── Dropdown.module.css   # Dropdown styles
│   │   │   ├── Dropdown.test.tsx     # Dropdown tests
│   │   │   └── index.ts              # Export file
│   │   ├── Tabs/
│   │   │   ├── Tabs.tsx              # Tabs component
│   │   │   ├── Tab.tsx               # Tab component
│   │   │   ├── Tabs.module.css       # Tabs styles
│   │   │   ├── Tabs.test.tsx         # Tabs tests
│   │   │   └── index.ts              # Export file
│   │   ├── Pagination/
│   │   │   ├── Pagination.tsx        # Pagination component
│   │   │   ├── Pagination.module.css # Pagination styles
│   │   │   ├── Pagination.test.tsx   # Pagination tests
│   │   │   └── index.ts              # Export file
│   │   ├── Toast/
│   │   │   ├── Toast.tsx             # Toast component
│   │   │   ├── ToastContainer.tsx    # Toast container
│   │   │   ├── Toast.module.css      # Toast styles
│   │   │   ├── Toast.test.tsx        # Toast tests
│   │   │   └── index.ts              # Export file
│   │   ├── Spinner/
│   │   │   ├── Spinner.tsx           # Loading spinner
│   │   │   ├── Spinner.module.css    # Spinner styles
│   │   │   └── index.ts              # Export file
│   │   ├── Skeleton/
│   │   │   ├── Skeleton.tsx          # Skeleton loader
│   │   │   ├── Skeleton.module.css   # Skeleton styles
│   │   │   └── index.ts              # Export file
│   │   ├── Tag/
│   │   │   ├── Tag.tsx               # Tag component
│   │   │   ├── Tag.module.css        # Tag styles
│   │   │   └── index.ts              # Export file
│   │   ├── Toggle/
│   │   │   ├── Toggle.tsx            # Toggle component
│   │   │   ├── Toggle.module.css     # Toggle styles
│   │   │   └── index.ts              # Export file
│   │   └── Tooltip/
│   │       ├── Tooltip.tsx           # Tooltip component
│   │       ├── Tooltip.module.css    # Tooltip styles
│   │       └── index.ts              # Export file
│   │
│   ├── layout/                       # Layout components
│   │   ├── Header/
│   │   │   ├── Header.tsx            # Header component
│   │   │   ├── Header.module.css     # Header styles
│   │   │   ├── MobileMenu.tsx        # Mobile menu
│   │   │   ├── NavLinks.tsx          # Navigation links
│   │   │   └── index.ts              # Export file
│   │   ├── Footer/
│   │   │   ├── Footer.tsx            # Footer component
│   │   │   ├── Footer.module.css     # Footer styles
│   │   │   └── index.ts              # Export file
│   │   ├── Sidebar/
│   │   │   ├── Sidebar.tsx           # Sidebar component
│   │   │   ├── Sidebar.module.css    # Sidebar styles
│   │   │   ├── SidebarItem.tsx       # Sidebar item
│   │   │   └── index.ts              # Export file
│   │   ├── MainLayout/
│   │   │   ├── MainLayout.tsx        # Main layout
│   │   │   ├── MainLayout.module.css # Main layout styles
│   │   │   └── index.ts              # Export file
│   │   ├── AdminLayout/
│   │   │   ├── AdminLayout.tsx       # Admin layout
│   │   │   ├── AdminLayout.module.css # Admin layout styles
│   │   │   ├── AdminSidebar.tsx      # Admin sidebar
│   │   │   └── index.ts              # Export file
│   │   ├── Container/
│   │   │   ├── Container.tsx         # Container component
│   │   │   └── index.ts              # Export file
│   │   └── PageHeader/
│   │       ├── PageHeader.tsx        # Page header component
│   │       └── index.ts              # Export file
│   │
│   ├── article/                      # Article components
│   │   ├── ArticleCard/
│   │   │   ├── ArticleCard.tsx       # Article card
│   │   │   ├── ArticleCard.module.css # Article card styles
│   │   │   └── index.ts              # Export file
│   │   ├── ArticleList/
│   │   │   ├── ArticleList.tsx       # Article list
│   │   │   ├── ArticleList.module.css # Article list styles
│   │   │   └── index.ts              # Export file
│   │   ├── ArticleDetail/
│   │   │   ├── ArticleDetail.tsx     # Article detail
│   │   │   ├── ArticleDetail.module.css # Article detail styles
│   │   │   └── index.ts              # Export file
│   │   ├── ArticleMeta/
│   │   │   ├── ArticleMeta.tsx       # Article metadata
│   │   │   └── index.ts              # Export file
│   │   ├── FeaturedArticle/
│   │   │   ├── FeaturedArticle.tsx   # Featured article
│   │   │   ├── FeaturedArticle.module.css # Featured article styles
│   │   │   └── index.ts              # Export file
│   │   ├── ArticleContent/
│   │   │   ├── ArticleContent.tsx    # Article content renderer
│   │   │   └── index.ts              # Export file
│   │   ├── RelatedArticles/
│   │   │   ├── RelatedArticles.tsx   # Related articles
│   │   │   └── index.ts              # Export file
│   │   └── TableOfContents/
│   │       ├── TableOfContents.tsx   # Table of contents
│   │       └── index.ts              # Export file
│   │
│   ├── comment/                      # Comment components
│   │   ├── CommentList/
│   │   │   ├── CommentList.tsx       # Comment list
│   │   │   └── index.ts              # Export file
│   │   ├── CommentItem/
│   │   │   ├── CommentItem.tsx       # Comment item
│   │   │   ├── CommentItem.module.css # Comment item styles
│   │   │   └── index.ts              # Export file
│   │   ├── CommentForm/
│   │   │   ├── CommentForm.tsx       # Comment form
│   │   │   └── index.ts              # Export file
│   │   └── CommentReplies/
│   │       ├── CommentReplies.tsx    # Comment replies
│   │       └── index.ts              # Export file
│   │
│   ├── editor/                       # Editor components
│   │   ├── RichTextEditor/
│   │   │   ├── RichTextEditor.tsx    # Rich text editor
│   │   │   ├── RichTextEditor.module.css # Editor styles
│   │   │   ├── extensions/           # Editor extensions
│   │   │   │   ├── index.ts          # Extensions exports
│   │   │   │   ├── image.ts          # Image extension
│   │   │   │   ├── codeBlock.ts      # Code block extension
│   │   │   │   └── link.ts           # Link extension
│   │   │   ├── menus/                # Editor menus
│   │   │   │   ├── BubbleMenu.tsx    # Bubble menu
│   │   │   │   └── FloatingMenu.tsx  # Floating menu
│   │   │   ├── plugins/              # Editor plugins
│   │   │   │   ├── imageUpload.ts    # Image upload plugin
│   │   │   │   └── placeholder.ts    # Placeholder plugin
│   │   │   └── index.ts              # Export file
│   │   ├── Toolbar/
│   │   │   ├── Toolbar.tsx           # Editor toolbar
│   │   │   ├── ToolbarButton.tsx     # Toolbar button
│   │   │   └── index.ts              # Export file
│   │   ├── ImageUploader/
│   │   │   ├── ImageUploader.tsx     # Image uploader
│   │   │   └── index.ts              # Export file
│   │   └── EditorControls/
│   │       ├── EditorControls.tsx    # Editor controls
│   │       └── index.ts              # Export file
│   │
│   ├── category/                     # Category components
│   │   ├── CategoryList/
│   │   │   ├── CategoryList.tsx      # Category list
│   │   │   └── index.ts              # Export file
│   │   ├── CategoryCard/
│   │   │   ├── CategoryCard.tsx      # Category card
│   │   │   └── index.ts              # Export file
│   │   └── CategoryBadge/
│   │       ├── CategoryBadge.tsx     # Category badge
│   │       └── index.ts              # Export file
│   │
│   ├── tag/                          # Tag components
│   │   ├── TagList/
│   │   │   ├── TagList.tsx           # Tag list
│   │   │   └── index.ts              # Export file
│   │   └── TagSelector/
│   │       ├── TagSelector.tsx       # Tag selector
│   │       └── index.ts              # Export file
│   │
│   ├── auth/                         # Auth components
│   │   ├── LoginForm/
│   │   │   ├── LoginForm.tsx         # Login form
│   │   │   └── index.ts              # Export file
│   │   ├── RegisterForm/
│   │   │   ├── RegisterForm.tsx      # Register form
│   │   │   └── index.ts              # Export file
│   │   └── PasswordResetForm/
│   │       ├── PasswordResetForm.tsx # Password reset form
│   │       └── index.ts              # Export file
│   │
│   ├── user/                         # User components
│   │   ├── UserProfile/
│   │   │   ├── UserProfile.tsx       # User profile
│   │   │   └── index.ts              # Export file
│   │   ├── ProfileForm/
│   │   │   ├── ProfileForm.tsx       # Profile form
│   │   │   └── index.ts              # Export file
│   │   └── UserAvatar/
│   │       ├── UserAvatar.tsx        # User avatar
│   │       └── index.ts              # Export file
│   │
│   ├── subscribe/                    # Subscription components
│   │   ├── SubscriptionForm/
│   │   │   ├── SubscriptionForm.tsx  # Subscription form
│   │   │   └── index.ts              # Export file
│   │   └── SubscriptionBanner/
│   │       ├── SubscriptionBanner.tsx # Subscription banner
│   │       └── index.ts              # Export file
│   │
│   ├── search/                       # Search components
│   │   ├── SearchBar/
│   │   │   ├── SearchBar.tsx         # Search bar
│   │   │   └── index.ts              # Export file
│   │   └── SearchResults/
│   │       ├── SearchResults.tsx     # Search results
│   │       └── index.ts              # Export file
│   │
│   └── admin/                        # Admin components
│       ├── Dashboard/
│       │   ├── DashboardCard.tsx     # Dashboard card
│       │   ├── DashboardStats.tsx    # Dashboard statistics
│       │   └── index.ts              # Export file
│       ├── ArticleForm/
│       │   ├── ArticleForm.tsx       # Article form
│       │   └── index.ts              # Export file
│       ├── ArticleTable/
│       │   ├── ArticleTable.tsx      # Article table
│       │   └── index.ts              # Export file
│       ├── CategoryForm/
│       │   ├── CategoryForm.tsx      # Category form
│       │   └── index.ts              # Export file
│       ├── CommentModeration/
│       │   ├── CommentModeration.tsx # Comment moderation
│       │   └── index.ts              # Export file
│       ├── SubscriberTable/
│       │   ├── SubscriberTable.tsx   # Subscriber table
│       │   └── index.ts              # Export file
│       └── StatisticsChart/
│           ├── StatisticsChart.tsx   # Statistics chart
│           └── index.ts              # Export file
│
├── features/                         # Feature-specific code
│   ├── auth/                         # Authentication feature
│   │   ├── index.ts                  # Feature exports
│   │   ├── api/                      # Auth API
│   │   │   └── auth.api.ts           # Auth API endpoints
│   │   ├── components/               # Auth-specific components
│   │   │   ├── ProtectedRoute.tsx    # Protected route component
│   │   │   └── AdminRoute.tsx        # Admin route component
│   │   └── utils/                    # Auth utilities
│   │       └── token.utils.ts        # Token utilities
│   │
│   ├── articles/                     # Articles feature
│   │   ├── index.ts                  # Feature exports
│   │   ├── api/                      # Articles API
│   │   │   └── articles.api.ts       # Articles API endpoints
│   │   ├── components/               # Article-specific components
│   │   │   ├── ArticleFilters.tsx    # Article filters
│   │   │   └── ArticleSorter.tsx     # Article sorter
│   │   └── utils/                    # Article utilities
│   │       └── article.utils.ts      # Article utilities
│   │
│   ├── comments/                     # Comments feature
│   │   ├── index.ts                  # Feature exports
│   │   ├── api/                      # Comments API
│   │   │   └── comments.api.ts       # Comments API endpoints
│   │   └── components/               # Comment-specific components
│   │       └── CommentFilters.tsx    # Comment filters
│   │
│   ├── categories/                   # Categories feature
│   │   ├── index.ts                  # Feature exports
│   │   └── api/                      # Categories API
│   │       └── categories.api.ts     # Categories API endpoints
│   │
│   ├── tags/                         # Tags feature
│   │   ├── index.ts                  # Feature exports
│   │   └── api/                      # Tags API
│   │       └── tags.api.ts           # Tags API endpoints
│   │
│   ├── subscribers/                  # Subscribers feature
│   │   ├── index.ts                  # Feature exports
│   │   └── api/                      # Subscribers API
│   │       └── subscribers.api.ts    # Subscribers API endpoints
│   │
│   ├── profile/                      # User profile feature
│   │   ├── index.ts                  # Feature exports
│   │   └── api/                      # Profile API
│   │       └── profile.api.ts        # Profile API endpoints
│   │
│   └── statistics/                   # Statistics feature
│       ├── index.ts                  # Feature exports
│       └── api/                      # Statistics API
│           └── statistics.api.ts     # Statistics API endpoints
│
├── services/                         # API services
│   ├── api.service.ts                # Base API service
│   ├── article.service.ts            # Article API service
│   ├── auth.service.ts               # Auth API service
│   ├── comment.service.ts            # Comment API service
│   ├── category.service.ts           # Category API service
│   ├── tag.service.ts                # Tag API service
│   ├── subscriber.service.ts         # Subscriber API service
│   ├── user.service.ts               # User API service
│   └── statistics.service.ts         # Statistics API service
│
├── utils/                            # Utility functions
│   ├── index.ts                      # Utility exports
│   ├── date.ts                       # Date formatting utilities
│   ├── string.ts                     # String utilities
│   ├── number.ts                     # Number formatting
│   ├── url.ts                        # URL utilities
│   ├── validation.ts                 # Validation utilities
│   ├── storage.ts                    # Storage utilities
│   ├── image.ts                      # Image utilities
│   ├── logger.ts                     # Logging utilities
│   ├── errorHandler.ts               # Error handling utilities
│   └── analytics.ts                  # Analytics utilities
│
├── store/                            # State management
│   ├── index.ts                      # Store exports
│   ├── context/                      # React Context state
│   │   └── [Already defined in context/]
│   └── zustand/                      # Zustand stores
│       ├── themeStore.ts             # Theme store
│       ├── sidebarStore.ts           # Sidebar store
│       └── modalStore.ts             # Modal store
│
└── pages/                            # Page components
├── Home/
│   ├── HomePage.tsx              # Home page
│   ├── components/               # Home-specific components
│   │   ├── Hero.tsx              # Hero section
│   │   ├── FeaturedArticlesSection.tsx # Featured articles
│   │   ├── RecentArticlesSection.tsx # Recent articles
│   │   ├── CategoriesSection.tsx # Categories section
│   │   └── NewsletterSection.tsx # Newsletter section
│   └── index.ts                  # Export file
│
├── Article/
│   ├── ArticlePage.tsx           # Article page
│   ├── components/               # Article page components
│   │   ├── ArticleHeader.tsx     # Article header
│   │   ├── ShareButtons.tsx      # Share buttons
│   │   └── AuthorBio.tsx         # Author bio
│   └── index.ts                  # Export file
│
├── Category/
│   ├── CategoryPage.tsx          # Category page
│   └── index.ts                  # Export file
│
├── Tag/
│   ├── TagPage.tsx               # Tag page
│   └── index.ts                  # Export file
│
├── Auth/
│   ├── LoginPage.tsx             # Login page
│   ├── RegisterPage.tsx          # Register page
│   ├── ForgotPasswordPage.tsx    # Forgot password page
│   ├── ResetPasswordPage.tsx     # Reset password page
│   └── index.ts                  # Export file
│
├── Search/
│   ├── SearchPage.tsx            # Search page
│   └── index.ts                  # Export file
│
├── About/
│   ├── AboutPage.tsx             # About page
│   └── index.ts                  # Export file
│
├── Profile/
│   ├── ProfilePage.tsx           # Profile page
│   └── index.ts                  # Export file
│
├── Subscribe/
│   ├── SubscribePage.tsx         # Subscribe page
│   ├── ConfirmSubscriptionPage.tsx # Confirm subscription
│   ├── UnsubscribePage.tsx       # Unsubscribe page
│   └── index.ts                  # Export file
│
├── NotFound/
│   ├── NotFoundPage.tsx          # 404 page
│   └── index.ts                  # Export file
│
└── Admin/
├── Dashboard/
│   ├── AdminDashboardPage.tsx # Admin dashboard
│   └── index.ts              # Export file
│
├── Articles/
│   ├── ArticleListPage.tsx   # Article list page
│   ├── CreateArticlePage.tsx # Create article page
│   ├── EditArticlePage.tsx   # Edit article page
│   └── index.ts              # Export file
│
├── Categories/
│   ├── CategoryListPage.tsx  # Category list page
│   ├── CreateCategoryPage.tsx # Create category page
│   ├── EditCategoryPage.tsx  # Edit category page
│   └── index.ts              # Export file
│
├── Tags/
│   ├── TagListPage.tsx       # Tag list page
│   └── index.ts              # Export file
│
├── Comments/
│   ├── CommentListPage.tsx   # Comment list page
│   └── index.ts              # Export file
│
├── Subscribers/
│   ├── SubscriberListPage.tsx # Subscriber list page
│   └── index.ts              # Export file
│
├── Statistics/
│   ├── StatisticsPage.tsx    # Statistics page
│   └── index.ts              # Export file
│
└── Settings/
├── SettingsPage.tsx      # Settings page
└── index.ts              # Export file