Feature: Completion for wildcards

  Scenario Outline: Wildcards are collected from correct sections
    Given a snakemake project
    Given I open a file "foo.smk" with text
    """
    <rule_like> NAME:
      conda: "{wildcard1}"
      resources: "{wildcard2}"
      group: "{wildcard3}"
      benchmark: "{wildcard4}"
      log: "{wildcard5}"
      output: "{wildcard6}"
      params: "{wildcard7}"
      input: "{}"
      message: "{non-wildcard1}"
      cwl: "{non-wildcard2}"
      script: "{non-wildcard3}"
      shell: "{non-wildcard4}"
    """
    When I put the caret after input: "{
    And I invoke autocompletion popup
    Then completion list should contain:
      | wildcard6     |
      | wildcard5     |
      | wildcard4     |
    And completion list shouldn't contain:
      | wildcard1     |
      | wildcard2     |
      | wildcard3     |
      | wildcard7     |
      | non-wildcard1 |
      | non-wildcard2 |
      | non-wildcard3 |
      | non-wildcard4 |
    Examples:
      | rule_like  |
      | rule       |
      | checkpoint |

  Scenario Outline: Wildcards are collected from all appropriate injections
    Given a snakemake project
    Given I open a file "foo.smk" with text
    """
    <rule_like> NAME:
      output: "{wildcard1}", expand("{wildcard2}"),
          "{wildcard3}" + "{wildcard4}" + "{wildcard5}",
          "{wildcard6}" '{wildcard7}' f"{{wildcard8}}"
          kwd="{wildcard6}"
      input: "{}"
    """
    When I put the caret after input: "{
    And I invoke autocompletion popup
    Then completion list should contain:
      | wildcard1 |
      | wildcard2 |
      | wildcard3 |
      | wildcard4 |
      | wildcard5 |
      | wildcard6 |
      | wildcard7 |
      | wildcard8 |
    Examples:
      | rule_like  |
      | rule       |
      | checkpoint |

  Scenario Outline: Wildcards are collected only from a parent rule
    Given a snakemake project
    Given I open a file "foo.smk" with text
    """
    <rule_like> ANOTHER_NAME:
        output: "{wildcard1}"

    <rule_like> NAME:
      output: "{wildcard2}"
      input: "{}"
    """
    When I put the caret after input: "{
    And I invoke autocompletion popup
    Then completion list should contain:
      | wildcard2 |
    And completion list shouldn't contain:
      | wildcard1 |
    Examples:
      | rule_like  |
      | rule       |
      | checkpoint |

  Scenario Outline: Complete a wildcard name
    Given a snakemake project
    Given I open a file "foo.smk" with text
    """
    <rule_like> NAME:
      output: "{wildcard}"
      input: "{}"
    """
    When I put the caret after input: "{
    Then I invoke autocompletion popup, select "wildcard" lookup item and see a text:
    """
    <rule_like> NAME:
      output: "{wildcard}"
      input: "{wildcard}"
    """
    Examples:
      | rule_like  |
      | rule       |
      | checkpoint |

  Scenario Outline: Completion list after wildcards.
    Given a snakemake project
    Given I open a file "foo.smk" with text
    """
    <rule_like> NAME:
      input: "{wildcard1}"
      output: "{wildcard2}{wildcard3}"
      shell: "{wildcards.}"
    """
    When I put the caret after wildcards.
    And I invoke autocompletion popup
    Then completion list should contain:
      | wildcard2 |
      | wildcard3 |
    Examples:
      | rule_like  |
      | rule       |
      | checkpoint |

  Scenario Outline: Complete after wildcards.
    Given a snakemake project
    Given I open a file "foo.smk" with text
    """
    <rule_like> NAME:
      output: "{wildcard}"
      shell: "{wildcards.}"
    """
    When I put the caret after wildcards.
    Then I invoke autocompletion popup and see a text:
    """
    <rule_like> NAME:
      output: "{wildcard}"
      shell: "{wildcards.wildcard}"
    """
    Examples:
      | rule_like  |
      | rule       |
      | checkpoint |