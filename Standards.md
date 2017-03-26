# CFH Java Coding Standards

# File Structure & Formatting
Here you'll find everything you'll need to know about the expected structure of your source file, and its formatting.

## Source File
All source files must follow a specific naming convention, and structure.

### Source File Naming
All source files should be named(case-sensitive) after the top-level class they contain.

### Source File Structure
All source files should be organized similarly to provide an easier experience to fellow developers.

The common structure, in order, is as follows:

- License information
- Package statement
- Import Statements
- Class Javadoc comment
- Only one top-level class

## Indentation & Line Wrapping
You should use a unit of indentation of two spaces.

### Length
Lines longer than 80 characters should be avoided, and wrapped when present.

### Wrapping
When you exceed the suggested length specified above for an expression you must break it
into multiple lines.


When to break:

- After commas
- Before operators


Indentation for breaks:

- Each new line for an expression that must be broken should be indented four spaces
from the start of the expression.

## Comments
Comments are formatted in a specific way to improve readability, and help guide developers to writing cleaning
code that requires less comments.

### Inline Comments
Inline comments should be preceded by `/*` and followed up by `*/`. Inline comments should be no longer than
forty characters, and consist of only one line. If you require more characters, or more lines you should re-evaluate your comment text, and/or think about moving it to a block comment.

### Block Comments
Inline comments should be preceded by `/*` and followed up by `*/`. Each line in a block comment should begin with an asterisk(*). Block comments should have no blank lines consisting of solely an asterisk(*) character. Block comments should be indented to the same level as the code they describe.

### Trailing Comments
Short comments may follow code they describe on the same line. They should be shifted at least four indentation units to help differentiate them from the code they describe. All trailing comments in the same code block should be aligned left-justified with each other.

### EOL Comments
End-of-line comments, also know as EOL comments here, are used to comment out full or partial lines of code. They should not be used on multiple consecutive lines for text comments. They can, however, be used on multiple consecutive lines to comment out blocks of code.

## Declarations
The maximum for declarations per line is one. This allows for developers to comment code without confusion.

### Location & Spacing

#### Spacing
The accepted method of declaration spacing is one space between the type and identifier.

#### Location
Declarations should be placed at the beginning of code blocks. This allows for better readability. Hiding a declaration behind a lower-level declaration should be avoided.

# Soft Standards
Standards located in this section are not organized in any particular fashion other than the fact they are currently not enforced, and are documented here for the sole purpose of allowing contributors to become informed of them before they are enforced.

# Additions
From time to time these standards may be updated, and it is solely the responsibility of each individual contributor to remain informed about any additions as they are communicated by means of; this document, developer blog posts, and/or community PSAs on the forums(coming soon). All new additions are provided as "Soft Standards", which are located in the Soft Standards section, when they are first implemented into the guidelines to allow for contributors to adjust accordingly before they are fully.

## Proposals
Addition proposals are accepted from anyone who feels that these standards don't adequately cover certain aspects of Java that is able to be formatted various ways. Proposals must follow a specific format to provide the most clear, understandable proposal.

### Format
The format to be used for proposals is as follows:

```
Proposal Format

Section: The section this proposal corresponds to, or the name of the new section proposed.

Addresses: The Java feature this addresses, and the various non-recommended formats and ways each format could impair code readability, and flow.

Proposed: The proposed recommended format for this particular Java feature, and how it makes code more readable than the alternative formats.
```
    

## Last Modified
The last date this document was modified. March 26th 2017

# Proposed Additions
These are additions that have been proposed for the coding standards, but still have to be voted upon by the core UAPI developers. Addition proposals must follow the guidelines specified in Additions > Proposals section of these standards.